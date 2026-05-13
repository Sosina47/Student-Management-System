# Student Management System Docs

This folder explains how the app is built and how the Vaadin pieces fit together.

Start here:

1. `architecture.md` for the big picture.
2. `vaadin-concepts.md` for the Vaadin terms used in the app.
3. `dashboard-guide.md` for dashboard-specific features and demo flow.
4. `source-guide.md` for a file-by-file walkthrough.
5. `distribution.md` for packaging and sharing the app.

The current app is a presentation/demo project built with:

- Spring Boot for application startup and dependency injection.
- Vaadin Flow for the UI.
- An in-memory student list for demo data.
- Reusable UI components to keep the views small and readable.

Run the app with:

```bash
cmd /c ".\\mvnw.cmd spring-boot:run"
```

Default demo login:

- Username: `admin`
- Password: `1234`
