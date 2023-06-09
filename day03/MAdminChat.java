import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class MAdminChat {
    private Map<String, User> users;

    MAdminChat() {
        users = Collections.synchronizedMap(new HashMap<>());
        new Thread(() -> speak()).start();
    }

    String addUser(Socket s) {
        User user;
        try {
            user = new User(s);
        } catch (IOException e) { // ignore
            return null;
        }

        if (users.containsKey(user.name)) {
            try {
                user.sendMessage("Server>> 같은 이름의 사용자가 있어 강제퇴장 처리합니다.");
                user.close();
            } catch (IOException e) {
                System.err.println("중복 처리중 오류: " + e);
            }
            return null;
        }

        users.put(user.name, user);
        System.out.print("\33[2K\r");
        System.out.println(user.name + "님이 입장했습니다.");
        System.out.print("> ");
        new Thread(() -> listen(user)).start();
        return user.name;
    }

    private void listen(User user) {
        String msg = null;
        try {
            while (true) {
                msg = user.recvMessage();
                System.out.print("\33[2K\r");
                System.out.println(user.name + ">> " + msg);
                System.out.print("> ");
                for (User u : users.values()) {
                    u.sendMessage(user.name + ">> " + msg);
                }
            }
        } catch (IOException ie) {
            System.out.print("\33[2K\r");
            System.out.println(user.name + "님이 퇴장하였습니다.");
            try {
                for (User u : users.values()) {
                    u.sendMessage(user.name + "님이 퇴장하였습니다.");
                }
            } catch (IOException iie) {
                System.err.println("메시지 전송 실패: " + iie);
            }
        } finally {
            try {
                for (User u : users.values()) {
                    u.sendMessage(user.name + "님이 퇴장하였습니다.");
                }
                user.close();
                users.remove(user.name);
            } catch (IOException e) {
                System.err.println("소켓 닫기 실패: " + e);
            }
        }
    }

    private void speak(String name) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = null;

        try {
            while (true) {
                System.out.print("> ");
                msg = br.readLine();
                for (User user : users.values()) {
                    user.sendMessage(name + ">> " + msg);
                }
            }
        } catch (IOException | NullPointerException e) { // Ctrl+C
            System.out.print("\33[2K\r");
            System.out.println("서버를 종료합니다.");
        } finally {
            try {
                for (User user : users.values()) {
                    user.sendMessage("Server>> 서버 종료 중입니다.");
                    user.close();
                }
                System.exit(0);
            } catch (IOException ie) {
                System.err.println("소켓 닫기 실패: " + ie);
            }
        }
    }

    private void speak() {
        speak("Admin");
    }
}
