# Multi-threading Example in Java

## Overview
This Java program demonstrates a simple use of multithreading by creating two `Person` threads that simulate a chat interaction. Each `Person` thread prints messages to the console while running, can take breaks, and stop talking based on external commands.

## Classes

### `Person`
- Extends the `Thread` class.
- Has two states:
  - **Active:** Whether the thread is running or stopped.
  - **Taking Break:** Whether the thread is currently on a break or actively "talking."
- Methods:
  - `run()` — Executes the thread logic, printing messages based on the break state.
  - `takeBreak()` — Sets the thread to break mode.
  - `comeBack()` — Resumes talking after a break.
  - `stopTalking()` — Stops the thread execution.

### `multi_threading`
- Contains the `main` method.
- Creates and starts two `Person` threads: John and Emma.
- Controls the threads by making John take a break and come back.
- Stops both threads and waits for them to finish before closing the chat room.

## How to Run

1. Compile the program:
   ```bash
   javac multi_threading.java
