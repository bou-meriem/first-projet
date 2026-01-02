package com.l3.gl.view;

import javax.swing.*;
import java.util.Random;

public class QuoteView {

    private static String[] quotes = {
            "La réussite appartient à ceux qui osent.",
            "Chaque jour est une nouvelle chance.",
            "Ne jamais abandonner.",
            "Le travail paie toujours."
    };

    public static void showQuote(Runnable onLogin) {
        JFrame frame = new JFrame("Welcome");
        frame.setSize(400, 200);

        JLabel quoteLabel = new JLabel(
                quotes[new Random().nextInt(quotes.length)],
                SwingConstants.CENTER
        );

        JButton loginBtn = new JButton("Connexion");

        loginBtn.addActionListener(e -> {
            frame.dispose();
            onLogin.run();
        });

        frame.add(quoteLabel, "Center");
        frame.add(loginBtn, "South");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}