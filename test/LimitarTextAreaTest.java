/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcos
 */
import static java.awt.AWTEventMulticaster.add;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import org.w3c.dom.events.DocumentEvent;

public class LimitarTextAreaTest extends JFrame {

    private JTextArea textArea;
    private DefaultStyledDocument doc;
    private JLabel remaningLabel = new JLabel();

    public LimitarTextAreaTest() {
        setLayout(new BorderLayout());

        textArea = new JTextArea(5, 15);
        doc = new DefaultStyledDocument();

       //aqui é atribuido um filtro ao DefaultStyledDocument, é esta classe que vai
       //limitar o número máximo de caracteres, basta alterar o 500
       //para o valor maximo desejado
        doc.setDocumentFilter(new DocumentSizeFilter(500));
        //neste trecho, foi sobrescrito um DocumentListener,
        //que monitora alterações dentro do campo de texto
        //sempre que uma alteração for realizada, será invocado
        //o método updateCount(), que vai atualizar o numero
        //de caracteres restantes
        doc.addDocumentListener(new DocumentListener() {
            
            public void changedUpdate(DocumentEvent e) {
                updateCount();
            }

            
            public void insertUpdate(DocumentEvent e) {
                updateCount();
            }

            
            public void removeUpdate(DocumentEvent e) {
                updateCount();
            }

            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        //finalmente o DefaultStyledDocument foi
        //atribuido ao seu campo de texto
        textArea.setDocument(doc);
        //insere o valor inicial restante
        updateCount();

        add(textArea, BorderLayout.NORTH);
        add(remaningLabel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        pack();
    }

    private void updateCount() {
        remaningLabel.setText((500 - doc.getLength()) + " caracteres restantes");
    }

    public static void main(String[] args) {
        new LimitarTextAreaTest().setVisible(true);
    }

    //esta classe que faz a limitação de caracteres
    class DocumentSizeFilter extends DocumentFilter {

        int maxCharacters;
        boolean DEBUG = false;

        public DocumentSizeFilter(int maxChars) {
            maxCharacters = maxChars;
        }

        public void insertString(DocumentFilter.FilterBypass fb, int offs,
                String str, AttributeSet a)
                throws BadLocationException {
            if (DEBUG) {
                System.out.println("in DocumentSizeFilter's insertString method");
            }

            //Isto rejeita novas inserções de caracteres se
            //a string for muito grande. Outra opção seria
            //truncar a string inserida, de forma que seja
            //adicionado somente o necessário para atingir
            //o limite máximo permitido
            if((fb.getDocument().getLength() + str.length()) <= maxCharacters) {
                super.insertString(fb, offs, str, a);
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        }

        public void replace(DocumentFilter.FilterBypass fb, int offs,
                int length,
                String str, AttributeSet a)
                throws BadLocationException {
            if (DEBUG) {
                System.out.println("in DocumentSizeFilter's replace method");
            }
            //Isto rejeita novas inserções de caracteres se
            //a string for muito grande. Outra opção seria
            //truncar a string inserida, de forma que seja
            //adicionado somente o necessário para atingir
            //o limite máximo permitido
            if((fb.getDocument().getLength() + str.length() - length) <= maxCharacters) {
                super.replace(fb, offs, length, str, a);
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        }

    }
}