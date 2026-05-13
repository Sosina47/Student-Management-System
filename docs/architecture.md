# Architecture

The app is organized in layers so each class has one main job.

## Flow Of Data

The UI views do not build or own business logic directly. Instead, they talk to `StudentService`, and the service owns the student list used for the demo.

The chain looks like this:

`UI views` -> `reusable Vaadin components` -> `StudentService` -> `MockStudentData`

This is a good presentation pattern because it shows separation of concerns:

- Views focus on layout and interactions.
- Components focus on reusable UI blocks.
- The service focuses on student operations.
- Mock data focuses on sample records only.

## Why The Service Layer Exists

`StudentService` centralizes the app’s student logic:

- get all students
- add a student
- update a student
- delete a student
- count students
- count departments
- search by name

Even though the data is still in memory, the views no longer need to know where the data comes from. That makes the app easier to explain and easier to replace later with a real database.

## Why Shared Components Exist

The app had repeated UI code in several views. The refactor moved the repeated pieces into reusable classes under `student/ui/components`.

That gives two benefits:

- The main views became much shorter.
- The same visual pattern can be reused on other pages later.

## What Is Still Demo-Only

The student list is not persisted to a database yet. When the app restarts, it still starts from the mock data again.

That is intentional for a class demo because it keeps the app easy to run and makes the architecture easier to show.
