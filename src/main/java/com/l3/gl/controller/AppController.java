package com.l3.gl.controller;

import com.l3.gl.model.Task;
import com.l3.gl.model.User;
import com.l3.gl.view.LoginView;
import com.l3.gl.view.MainView;
import com.l3.gl.view.QuoteView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AppController {

    private User user;
    private List<Task> tasks = new ArrayList<>();
    private MainView mainView;

    public void start() {
        QuoteView.showQuote(this::login);
    }

    private void login() {
        String name = LoginView.login();
        if (name != null && !name.isEmpty()) {
            user = new User(name);
            openMainView();
        }
    }

    private void openMainView() {
        mainView = new MainView(
                tasks,
                this::addTask,
                this::deleteTask,
                this::logout
        );
    }

    private void addTask() {
        String desc = JOptionPane.showInputDialog("Nouvelle tâche :");
        if (desc != null && !desc.isEmpty()) {
            tasks.add(new Task(desc));
            mainView.updateTasks(tasks);
        }
    }

    private void deleteTask() {
        if (!tasks.isEmpty()) {
            tasks.remove(tasks.size() - 1);
            JOptionPane.showMessageDialog(null, "Tâche supprimée !");
            mainView.updateTasks(tasks);
        }
    }

    private void logout() {
        tasks.clear();
        start();
    }

    public static void main(String[] args) {
        new AppController().start();
    }
}