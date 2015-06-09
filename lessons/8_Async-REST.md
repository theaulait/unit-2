### Async Task and REST APIs

#### Objective

Students will become familiar with Async Task and begin to use REST APIs in their Android applications.

#### Do Now

Create an app. The main activity should have a ListView and a button that says "Reload."

#### Lesson

##### Async Task

The UI thread is the thread that controls the interface - it makes updates to what is displayed to the user. There
are other threads that are running concurrently, that is, the device switches between doing many things at once, and
programs aren't necessarily linear.

Async Task allows you to perform background operations - operations that should not be on the UI thread - and publish
these operations to the UI thread when they are done.

A few APIs you need to know for Async Task:

[`doInBackground`](http://developer.android.com/reference/android/os/AsyncTask.html#doInBackground(Params...)) -
The main method you override to execute a task in the background.

[`onPostExecute`](http://developer.android.com/reference/android/os/AsyncTask.html#onPostExecute(Result)) - The
method that gets called on the UI thread using the result from `doInBackground`.

[`onCancelled`](http://developer.android.com/reference/android/os/AsyncTask.html#onCancelled(Result)) - The method
that gets called when the task is cancelled. If this is called, then `onPostExecute` won't be called.

##### REST

REST mean "internety." It's stateless. Like the internet.

##### Using a web API

Reach into yourself and remember using JSON.

#### Exercise

Use the Flickr API to create a Flickr Feed app.

Use https://api.flickr.com/services/feeds/photos_public.gne?format=json to grab the latest 20 images uploaded to
Flickr. When you click the "Reload" button, populate the view with the images.

#### Bonus

Update the images periodically - e.g. once every 5 seconds. The number of seconds should be specified by the user.
Include stop and start buttons.

#### Assessment
