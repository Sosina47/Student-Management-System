# Source Guide

This is a file-by-file guide to the important source code.

## Application Entry Point

### `src/main/java/com/studentmanagement/Application.java`

This is the Spring Boot entry point.

It starts the app and also registers the Vaadin stylesheet resources with `@StyleSheet`.

The important idea is that Spring Boot launches the server and Vaadin renders the UI through the same application.

## Layout

### `src/main/java/com/studentmanagement/student/layout/MainLayout.java`

This is the shared app shell.

It builds the navigation drawer with links to Dashboard, Students, and About. It also includes the reusable dark mode toggle.

Vaadin note: because this class extends `AppLayout`, every routed page using this layout appears inside the same navigation shell.

## Login Page

### `src/main/java/com/studentmanagement/student/ui/LoginView.java`

This is the start page at `/`.

It contains:

- the app title
- the theme toggle button
- a Vaadin `LoginForm`
- a small sign-up form built with Vaadin fields and `FormLayout`
- tab switching between login and sign-up

Vaadin note: `UI.getCurrent().navigate("dashboard")` moves the user to another routed view after successful login.

## Dashboard Page

### `src/main/java/com/studentmanagement/student/ui/DashboardView.java`

This page shows summary numbers from `StudentService`.

It uses the reusable `MetricCard` component to display:

- total students
- number of departments
- demo system status

Vaadin note: this is a simple example of a read-only analytics page built with layouts and styled cards.

## Student Management Page

### `src/main/java/com/studentmanagement/student/ui/StudentView.java`

This view is now intentionally small.

It only does three things:

- declares the route
- applies the main layout
- adds `StudentCrudPanel`

The real CRUD logic moved into the reusable component so the view itself stays clean.

### `src/main/java/com/studentmanagement/student/ui/components/StudentCrudPanel.java`

This component contains the full student management experience.

It is responsible for:

- the title
- the student count card
- the search box
- the Binder-based form
- the grid
- the edit and delete buttons
- saving data through `StudentService`

Vaadin concepts used here:

- `Binder` for binding and validation
- `Grid` for displaying rows
- component columns for the action buttons
- notifications for user feedback

This is the most important example of how the app was modularized.

## About Page

### `src/main/java/com/studentmanagement/student/ui/AboutView.java`

This page explains Vaadin and the project.

It uses:

- `SectionHeading` for section titles
- `InfoCard` for feature and technology cards
- `HorizontalLayout` for card rows
- lists and text blocks for the explanation sections

The page is meant to help during presentation, so it focuses on clarity and visual structure.

## Reusable UI Components

### `src/main/java/com/studentmanagement/student/ui/components/SectionHeading.java`

Reusable styled `H2` for page sections.

### `src/main/java/com/studentmanagement/student/ui/components/MetricCard.java`

Reusable stat card for dashboard-style numbers.

It is used in the dashboard and in the student management page.

### `src/main/java/com/studentmanagement/student/ui/components/InfoCard.java`

Reusable card for icon + title + description content.

It is used in the About page for feature cards and technology cards.

### `src/main/java/com/studentmanagement/student/ui/components/ThemeToggleButton.java`

Reusable dark mode button.

It is used in the login page and in the main layout.

## Service Layer

### `src/main/java/com/studentmanagement/student/service/StudentService.java`

This is the business logic layer for students.

It stores the demo students in memory and exposes methods for:

- retrieving students
- adding, updating, and deleting students
- counting students
- counting departments
- searching by name

The service also assigns a new ID when a new student does not already have one.

Vaadin note: the views call this service directly, which keeps the UI from owning the business logic.

## Mock Data

### `src/main/java/com/studentmanagement/student/mock/MockStudentData.java`

This class creates the demo student list.

It is not a UI class. It only exists to provide sample records for the service layer.

## Model

### `src/main/java/com/studentmanagement/student/model/Student.java`

This is the plain Java object that represents a student.

It holds:

- id
- name
- department
- year
- section

Vaadin note: the Binder in the student form binds directly to this model.
