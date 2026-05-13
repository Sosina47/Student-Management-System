# Dashboard Guide

This document explains the updated dashboard and how to present it in class.

## What Was Added

The dashboard now includes:

- Icon metric cards for total students and departments.
- A green status badge for system status.
- A refresh button to reload server-side data on demand.
- A test alert button using Vaadin notifications.
- A department distribution chart-style section.
- A quick-view grid with the last 3 added students.

## Modular Structure

Main route view:

- `src/main/java/com/studentmanagement/student/ui/DashboardView.java`

Main dashboard container:

- `src/main/java/com/studentmanagement/student/ui/components/DashboardPanel.java`

Sub-components used by the panel:

- `DashboardActionBar` for refresh and alert actions
- `DashboardSummaryCards` for top KPI cards
- `IconMetricCard` for icon + metric value card UI
- `SystemStatusCard` + `StatusBadge` for status display
- `DepartmentDistributionChart` for chart-style department breakdown
- `RecentStudentsGrid` for quick-view recent records

This keeps `DashboardView` very small and easy to read.

## Chart Explanation

File:

- `src/main/java/com/studentmanagement/student/ui/components/DepartmentDistributionChart.java`

This project does not use a paid chart package. Instead, it builds a clear chart-like visualization using free Vaadin components:

- grouped counts from Java stream logic
- one `ProgressBar` per department
- percentage labels shown next to each bar

Why this is good for demo:

- no external chart dependency
- still visually communicates distribution clearly
- shows how Vaadin components can be composed to make custom UI patterns

## Real-Time Refresh Behavior

When the refresh button is clicked:

1. The UI calls `DashboardPanel.refresh()`.
2. The panel reads data from `StudentService`.
3. Cards, chart rows, and recent grid all update.
4. A notification confirms the refresh action.

This demonstrates server-side state sync in pure Java.

## Quick Demo Script

1. Open Dashboard and show the cards with icons.
2. Mention the status badge theme (`badge success`).
3. Click Test System Alert to show instant feedback.
4. Add a student in Students page.
5. Return to Dashboard and click Refresh Metrics.
6. Show that total count and Last 3 Added Students update.
7. Explain that the department chart bars are computed on the server.
