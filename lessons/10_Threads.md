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

#### The Android Main Thread

The UI thread is the main thread, and it in charge of updating the UI. Other threads may interact with the main thread to update the UI or do other things such as run a service or running the onReceive method in a broadcast receiver. Because this thread updates the UI, actions that are performed on it should be quick and discrete.  If the UI thread were to be used to access the internet or download a file, for example, then the user would be unable to interact with the application until that operation was completed. This is why background threads are used.

Background threads are threads other than the main thread.  They do not make changes to the UI.  While information from a background thread may be used to update the UI, the UI is updated by the UI thread. Anything that could block the UI thread, such as a database access, should go on a background thread.

#### 
### Exercise (Morning)

Add a "reset" button to the app from the Do Now. When the reset button is pressed, a new random number should be
generated and the countdown should start again. Notice how in the current implementation, the reset button cannot be pressed while the UI thread is blocked. *Never block the UI thread.*

Modify the implementation so that a background thread is used to sleep instead of the UI thread. When the reset button is pressed, interrupt the sleeping thread and restart the timer.

### Pod Meetings

### Do Now (Afternoon)

**TODO**

### Lesson (Afternoon)

#### Asynchronous Android Programming

##### Runnables

A Runnable is an object that is used to pass around code to be executed. The code is contained in the `run` method. The code from a runnable can be executed on the current thread, or passed to another thread for execution.

##### AsyncTask

An AsyncTask is an object that defines a task to be executed in a background thread. The `doInBackground` method must be implemented, and the code runs in the background. The `onPostExecute` method runs on the UI thread, and can use the result of `doInBackground`, which it takes in as a parameter.

Some methods from AsyncTask run on the UI thread, while some run in a background thread - e.g. `publishProgress` posts an update from the background thread, while `onProgressUpdate` runs on the UI thread using the information from `publishProgress`.

##### IntentService

Unlike a regular Service, an IntentService handles asynchronous requests, expressed as Intents, on demand. Clients send requests through `startService(Intent)` calls; the service is started as needed, handles each Intent in turn using a worker thread, and stops itself when it runs out of work.

This "work queue processor" pattern is commonly used to offload tasks from an application's main thread.  To use it, extend IntentService and implement onHandleIntent(Intent). IntentService will receive the Intents, launch a worker thread, and stop the service as appropriate.

All requests are handled on a single worker thread -- they may take as long as necessary (and will not block the application's main loop), but only one request will be processed at a time.

##### Handlers

A Handler allows you to send and process Message and Runnable objects associated with a thread's MessageQueue. Each Handler instance is associated with a single thread and that thread's message queue. When you create a new Handler, it is bound to the thread / message queue of the thread that is creating it -- from that point on, it will deliver messages and runnables to that message queue and execute them as they come out of the message queue.

There are two main uses for a Handler: (1) to schedule messages and runnables to be executed as some point in the future; and (2) to enqueue an action to be performed on a different thread than your own.

### Exercises (Afternoon)

1. Implement the 5-second guess limit using a Handler.
1. Implement the 5-second guess limit using a Service.
1. Implement the 5-second guess limit using an AsyncTask.
1. Implement the 5-second guess limit using a CountDownTimer.
1. Using the CountDownTimer, update the UI so that it displays how many seconds remain to guess a number.

**TODO: Needs one more exercise**

#### Homework

**TODO: Make hw doc and link to**

### Assessment

[Exit Ticket]()

#### Resources
Video Tutorials:
* #1 [Processes and Threads, an Overview](https://www.youtube.com/watch?v=IcIFJ5V3Ibg)
* #4 [Components and the UI Thread](https://www.youtube.com/watch?v=A0PAhoHzlsQ)
* #5 [Android Multithreading Overview](https://www.youtube.com/watch?v=lznss-0gEHU)
* #11 [Intro to Handlers & Loopers](https://www.youtube.com/watch?v=LJ_pUlWzGsc)
* #15 [Intro to AsyncTasks](https://www.youtube.com/watch?v=V4q0sTIntsk)
