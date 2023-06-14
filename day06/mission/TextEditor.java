import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TextEditor extends JFrame {
    private Container cp;
    private JFileChooser fileChooser;
    private JMenuBar menuBar;
    private JMenu fileMenu, editMenu;
    private JMenuItem openMenuItem, saveMenuItem, exitMenuItem, clearMenuItem;
    private JTextArea textArea;

    //private ActionListener newListener;
    private ActionListener openListener;
    private ActionListener saveListener;

    private File file;
    private BufferedReader br;
    private static final Charset UTF8 = Charset.forName("UTF-8");

    private void init() {
        cp = getContentPane();
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Java source file (.java)", "java"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text file (.txt)", "txt"));

        initListeners();
        initUI();
        setUI();
    }

    private void initListeners() {
        //newListener = e -> {

        // };
        openListener = e -> {
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
                if (textArea == null) {
                    textArea = new JTextArea();
                    textArea.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
                    cp.add(new JScrollPane(textArea));
                    saveMenuItem.setEnabled(true);
                    clearMenuItem.setEnabled(true);
                    cp.revalidate();
                }

                textArea.setText("");
                String line = null;
                try {
                    br = new BufferedReader(new FileReader(file, UTF8));
                    while ((line = br.readLine()) != null) {
                        textArea.append(line);
                        textArea.append("\n");
                    }
                } catch (IOException ie) {
                    System.err.println(ie);
                }
                
            }
        };

        saveListener = e -> {
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File saveFile = fileChooser.getSelectedFile();
                
                if (saveFile.exists()) {
                    int overwriteOption = JOptionPane.showConfirmDialog(cp, "File exists. Overwrite?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (overwriteOption == JOptionPane.NO_OPTION) {
                        return;
                    }
                }

                PrintWriter pw = null;
                try {
                    pw = new PrintWriter(saveFile, UTF8);
                } catch (IOException e1) {
                    System.err.println(e);
                }
                pw.write(textArea.getText());
                pw.flush();
            }
        };
    }

    private void initUI() {
        menuBar = new JMenuBar();

        fileMenu = new JMenu("File", false);
        menuBar.add(fileMenu);
        openMenuItem = fileMenu.add("Open...");
        openMenuItem.addActionListener(openListener);
        saveMenuItem = fileMenu.add("Save As...");
        saveMenuItem.addActionListener(saveListener);
        saveMenuItem.setEnabled(false);
        fileMenu.addSeparator();
        exitMenuItem = fileMenu.add("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));

        editMenu = new JMenu("Edit", true);
        menuBar.add(editMenu);
        clearMenuItem = editMenu.add("Clear");
        clearMenuItem.setEnabled(false);
        clearMenuItem.addActionListener(e -> textArea.setText(""));
        cp.add(menuBar, BorderLayout.NORTH);
    }

    private void setUI() {
        setTitle("Text Editor (Warning: UTF-8 only)");
        setSize(800, 600);
        setVisible(true);
        // setLocation(200, 100);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.init();
    }
}