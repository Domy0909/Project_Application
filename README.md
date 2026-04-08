# Task Automation Application (IFTTT-like)

## Project Description

This project is developed for the *Software Engineering course* at the University of Salerno.
The goal is to design and implement a **simple task automation application**, inspired by IFTTT, following the provided **User Epics** and using the **Scrum methodology**.
The application allows a user to define rules composed of:
* a **trigger**
* an **action**
The system periodically checks whether triggers are satisfied and executes the corresponding actions.

## Functional Overview

### Basic Functionality

* The user can define rules
* Each rule contains:
  * a trigger (e.g., time of day)
  * an action (e.g., show a message or play audio)
* The system checks rules periodically
* When a trigger is verified, the rule is executed

### Rule Management

* Add new rules
* Delete existing rules
* Activate / deactivate rules
* Rules are saved and reloaded when the application restarts
* Rules can be:
  * executed only once
  * or repeated after a specified time interval

### Extended Features (based on User Epics)

* Additional triggers (date, file conditions, etc.)
* Additional actions (file operations, program execution)
* Logical combination of triggers (AND, OR, NOT)
* Counters (integer variables usable in triggers and actions)

> Note: Not all features are required to be completed. Development follows priority and time constraints.

---

## Development Process (Scrum)

The project is developed using the **Scrum framework**.

### Sprint Organization

Each sprint includes:

* Sprint Planning
* Daily Meetings
* Development and integration
* Code Review
* Sprint Review
* Sprint Retrospective

### Time Commitment

* Each team member works approximately **10 hours per week**
* Work is distributed across multiple days

---

##  Scrum Artifacts

The repository includes:

* **Product Backlog**
* **Sprint Backlogs**
* **Burndown Chart** (project-level)
* **Sprint Review Reports**
* **Sprint Retrospective Reports**

Additional tools:

* **Trello** is used to manage tasks and track progress

---

## Project Requirements

According to the assignment, the repository must contain:

* Source code
* Unit tests (JUnit)
* Software architecture description
* Scrum artifacts (backlogs, reports, burndown chart)
* Final presentation

---

## Testing

* Unit tests are implemented using **JUnit**
* Tests focus on:
  * core logic
  * correctness of rule execution

---

## Notes

* The project is **time-boxed**, so completeness is not required
* Priority is given to:
  * design quality
  * code quality
  * adherence to Scrum process

---

## Team
- Alessia Lettieri (ale0799)
- Marco Panico (mpanico20)
- Domenico Napolitano (Domy0909)
- Alessandro Passannante (AlessandroPassannanteUNI)

## Disclaimer
This project is developed for academic purposes as part of a Software Engineering course.


GROUP 19 REPOSITORY
Link al Product Backlog, Sprint Backlog e Burndown chart del gruppo :
https://unisalerno-my.sharepoint.com/:x:/r/personal/a_lettieri36_studenti_unisa_it/_layouts/15/Doc.aspx?sourcedoc=%7BE9D4C03D-7455-47E0-AE69-50B2DBE2FDA2%7D&file=product%20backlog.xlsx&action=default&mobileredirect=true

Link Trello:
https://trello.com/b/ByVwYjiL/scrum-board-gruppo-19
