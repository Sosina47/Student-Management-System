package com.studentmanagement.student.ui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.*;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.*;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.component.tabs.*;
import com.vaadin.flow.component.textfield.*;
import com.vaadin.flow.router.*;
import com.studentmanagement.student.ui.components.ThemeToggleButton;

@Route("")
@PageTitle("Login")
public class LoginView extends VerticalLayout {

    public LoginView() {

        setSizeFull();
        setSpacing(true);
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        // Title
        H1 title = new H1("Student Management System");

        // Dark Mode Button
        ThemeToggleButton themeToggle = new ThemeToggleButton("Dark Mode", VaadinIcon.MOON);

        // =========================
        // LOGIN FORM
        // =========================

        LoginForm loginForm = new LoginForm();

        loginForm.addLoginListener(event -> {

            String username = event.getUsername();
            String password = event.getPassword();

            if (username.equals("admin")
                    && password.equals("1234")) {

                Notification.show(
                        "Login Successful!"
                );

                UI.getCurrent()
                        .navigate("dashboard");

            } else {

                loginForm.setError(true);
            }
        });

        // =========================
        // SIGNUP FORM
        // =========================

        H2 signupTitle = new H2("Sign Up");

        TextField signupUsername =
                new TextField("Username");

        EmailField signupEmail =
                new EmailField("Email");

        PasswordField signupPassword =
                new PasswordField("Password");

        Button signupButton =
                new Button("Create Account");

        signupButton.addThemeVariants(
                ButtonVariant.LUMO_PRIMARY
        );

        signupButton.setWidthFull();

        signupButton.addClickListener(e -> {

            Notification.show(
                    "Account Created Successfully!"
            );
        });

        FormLayout signupForm =
                new FormLayout();

        signupForm.add(
                signupUsername,
                signupEmail,
                signupPassword,
                signupButton
        );

        signupForm.setWidthFull();

        // =========================
        // TABS
        // =========================

        Tab loginTab = new Tab("Login");
        Tab signupTab = new Tab("Sign Up");

        Tabs tabs = new Tabs(
                loginTab,
                signupTab
        );

        tabs.setWidth("450px");

        // =========================
        // SHARED CONTAINER
        // =========================

        VerticalLayout formContainer =
                new VerticalLayout();

        formContainer.setWidth("450px");
        formContainer.setPadding(true);
        formContainer.setSpacing(true);

        formContainer.getStyle()
                .set("border-radius", "15px")
                .set("box-shadow",
                        "0 4px 15px rgba(0,0,0,0.2)")
                .set("background-color",
                        "var(--lumo-base-color)");

        // Default view
        formContainer.add(loginForm);

        // Tab switching
        tabs.addSelectedChangeListener(event -> {

            formContainer.removeAll();

            if (event.getSelectedTab()
                    == loginTab) {

                formContainer.add(loginForm);

            } else {

                formContainer.add(
                        signupTitle,
                        signupForm
                );
            }
        });

        // Final Layout
        add(
                title,
                themeToggle,
                tabs,
                formContainer
        );
    }
}