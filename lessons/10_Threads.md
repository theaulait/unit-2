## Multithreading in Android

### Objective

Students will become comfortable with:

* what processes and threads are in general
* how processes and threads work on Android
* the role of the main (aka UI) thread and what to do and NOT do 
* the different ways to work with threading on Android

### Do Now (Morning)

Create a number-guessing Android app. The app should generate a random integer between 1 and 10, then prompt the user to guess a number. When the user hits the "submit" button, it tells the user if the guess was correct.

Add a feature so that it gives the user 5 seconds to guess a number. User the `sleep` method in order to pause
execution for 5 seconds.

### Lesson (Morning)

[Slides here](https://docs.google.com/presentation/d/1CTUlfE41tgwUspWus_p8MfjmBU9ahmtcG8F5Ko9cD00/edit?usp=sharing)

#### Processes

A process is a running program; all the threads in a process have access to shared memory, and each process running has its own memory. The CPU of a machine handles running several processes at once.

#### Threads

A thread represents one path of execution in a process. Threads can run concurrently, which makes them tricky to reason about.

#### The UI Thread

The UI thread is the main thread, and it in charge of updating the UI. Other threads may interact with the main thread to update the UI or do other things such as run a service or running the onReceive method in a broadcast receiver. Because this thread updates the UI, actions that are performed on it should be quick and discrete. If the
UI thread were to be used to access the internet or download a file, for example, then the user would be unable to interact with the application until that operation was completed. This is why background threads are used.

#### Background Threads

Background threads are threads that are no visible to the user - i.e. do not make changes to the UI. While information from a background thread may be used to update the UI, the UI is updated by the UI thread. Anything that could block the UI thread, such as a database access, should go on a background thread.

### Exercise (Morning)

Add a "reset" button to the app from the Do Now. When the reset button is pressed, a new random number should be
generated and the countdown should start again. Notice how in the current implementation, the reset button cannot be pressed while the UI thread is blocked. *Never block the UI thread.*

Modify the implementation so that a background thread is used to sleep instead of the UI thread. When the reset button is pressed, interrupt the sleeping thread and restart the timer.

### Pod Meetings

### Do Now (Afternoon)



### Lesson (Afternoon)

#### Concurrency Models

##### Runnables

##### AsyncTask

##### IntentService

##### Handlers

### Exercises (Afternoon)

1. Implement the 5-second guess limit using a Service.
2. Implement the 5-second guess limit using an AsyncTask.
3. Implement the 5-second guess limit using a CountDownTimer.
4. Using the CountDownTimer, update the UI so that it displays how many seconds remain to guess a number.

### Assessment

[Exit Ticket]()

#### Resources
Video Tutorials:
* #1 [Processes and Threads, an Overview](https://www.youtube.com/watch?v=IcIFJ5V3Ibg)
* #4 [Components and the UI Thread](https://www.youtube.com/watch?v=A0PAhoHzlsQ)
* #5 [Android Multithreading Overview](https://www.youtube.com/watch?v=lznss-0gEHU)
* #11 [Intro to Handlers & Loopers](https://www.youtube.com/watch?v=LJ_pUlWzGsc)
* #15 [Intro to AsyncTasks](https://www.youtube.com/watch?v=V4q0sTIntsk)
