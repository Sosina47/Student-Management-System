# Vaadin Concepts Used In This App

This file explains the Vaadin-specific code patterns used in the project.

## `@Route`

`@Route` turns a Java class into a navigable page.

Examples in this app:

- `LoginView` is the root page.
- `DashboardView` is available at `/dashboard`.
- `StudentView` is available at `/students`.
- `AboutView` is available at `/about`.

Vaadin creates the page from the Java component tree, so you do not write HTML templates manually for these views.

## `AppLayout`

`MainLayout` extends `AppLayout`, which gives the app a shared shell.

In this project, `MainLayout` provides:

- the app title
- navigation links
- the dark mode toggle
- a consistent drawer for the routed views

Any page using `layout = MainLayout.class` appears inside that shared shell.

## `VerticalLayout` And `HorizontalLayout`

These are Vaadin’s most common layout containers.

- `VerticalLayout` stacks components top to bottom.
- `HorizontalLayout` places components side by side.

They are used throughout the app to build cards, form rows, and dashboard rows.

## `Binder`

`Binder` connects fields to a Java object.

In `StudentCrudPanel`, Binder does two jobs:

- it copies field values into a `Student` object
- it validates the user input before save

This is one of the most important Vaadin patterns in the app because it demonstrates typed form binding without manual parsing.

## Validation

Validation is attached directly to each bound field.

Examples:

- student name is required
- student name must be at least 2 characters
- department is required
- year is required
- section is required

This means the UI itself protects the data before it reaches the service.

## `Grid`

`Grid` shows the student list in a table-like view.

The app uses:

- regular text columns for name, department, year, and section
- a component column for Edit and Delete buttons

That is a classic Vaadin CRUD pattern and shows why Grid is a strong fit for admin-style apps.

## Component Columns

Component columns let you place full Vaadin components inside a grid cell.

In this app, the Actions column contains buttons instead of plain text. That makes each row interactive.

## `Notification`

`Notification.show(...)` is used for short feedback messages.

Examples:

- login success
- student added
- student updated
- student deleted
- editing started

## Theme And Lumo Styling

The project uses Lumo theme tokens like `var(--lumo-primary-color)` and `var(--lumo-base-color)`.

This is the preferred Vaadin styling style because it keeps the UI consistent with the theme system and makes dark mode easier to support.

The shared `ThemeToggleButton` switches the UI between light and dark mode by changing the current UI theme list.

## Why This Is A Vaadin App And Not A Traditional Frontend App

The UI is built directly in Java classes.

That means:

- there is no React or Angular code in this project
- the server controls the component tree
- routing, state, and validation are all expressed in Java

That is the main Vaadin idea the project is demonstrating.
