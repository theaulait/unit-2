### Adapters and Adapter Views

#### Objective

Students will become comfortable using adapters to create views.

#### Do Now

Create an application that lists the seven days of a week using TextViews in a LinearLayout.

#### Lesson

##### Bootcamp Review

##### Adapters

Adapters are objects that process data for representation by and [AdapterView](https://developer.android.com/reference/android/widget/AdapterView.html). There are several common AdapterViews, including ListView and GridView.

##### ViewBinders

[ViewBinder documentation](https://developer.android.com/reference/android/widget/SimpleAdapter.ViewBinder.html)

A ViewBinder is an object provided in SimpleAdapter which binds values to views. These values can be any relevant
data which you want associated with a View.

[Code Examples](http://www.programcreek.com/java-api-examples/index.php?api=android.widget.SimpleAdapter.ViewBinder)

##### ArrayAdapter

An [ArrayAdapter](http://developer.android.com/reference/android/widget/ArrayAdapter.html) is a special kind of adapter that takes in an Array as data and uses the toString() function for each Object in the Array to create a series of TextViews, which then get used in the AdapterView.

##### AdapterViews

A ListView is a type of view that displays items in a list, while a GridView displays items in a grid. Android has
default settings for both of these types of layouts. While an ArrayAdapter is one way to display information in both views, there are other default adapters as well, as creating a custom adapter.

#### Exercise

Working in your homework groups:

1. Modify your app from the Do Now to use a ListView.

1. Build an application using a [ListView](http://developer.android.com/guide/topics/ui/layout/listview.html). Use
an adapter to populate the ListView with a list in the XML resouces.

1. Build an application using a [GridView](http://developer.android.com/guide/topics/ui/layout/gridview.html) Use an
adapater to populate the GridView with a list in the XML resources.

1. Using an app you've already created, refactor the code to use either a ListView or a GridView in place of your
current view.

#### Assessment

[Exit Ticket](https://docs.google.com/forms/d/1a-gfjjsn35N-C6wrQU9y02vHoYLFaEfjUgD7J91n3rM/viewform?usp=send_form)

#### Resources

* Android Docs: [The Adapter Class](http://developer.android.com/reference/android/widget/Adapter.html), [Building Layouts with an Adapter](http://developer.android.com/guide/topics/ui/declaring-layout.html#AdapterViews)
* Udacity course: [ListViews and Adapters](https://www.udacity.com/course/viewer#!/c-ud853/l-1395568821/e-1395668591/m-1395668592)
* Textbook: Adapter Views and Adapters
