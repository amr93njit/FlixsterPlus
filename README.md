# Android Project 3 - *FlixsterPlus Part 1*

Submitted by: **Adam Ramsey**

**Name of your app** is a movie browsing app that allows users to browse movies currently playing in theaters.

Time spent: **4** hours spent in total

## Required Features

The following **required** functionality is completed:

- [x] **Make a request to [The Movie Database API's `now_playing`](https://developers.themoviedb.org/3/movies/get-now-playing) endpoint to get a list of current movies**
- [x] **Parse through JSON data and implement a RecyclerView to display all movies**
- [x] **Use Glide to load and display movie poster images**

The following **optional** features are implemented:

- [x] Improve and customize the user interface through styling and coloring
- [x] Implement orientation responsivity
  - App should neatly arrange data in both landscape and portrait mode
- [x] Implement Glide to display placeholder graphics during loading
  - Note: this feature is difficult to capture in a GIF without throttling internet speeds.  Instead, include an additional screencap of your Glide code implementing the feature.  (<10 lines of code)

The following **additional** features are implemented:

- [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='flixster+p1_portrait.gif' title='Video Walkthrough, Portrait Mode' width='' alt='Video Walkthrough, Portrait Mode' />
<img src='flixster+p1_landscape.gif' title='Video Walkthrough, Landscape Mode' width='' alt='Video Walkthrough, Landscape Mode' />
<img src='placeholder_error.PNG' title='Glide Placeholder Code' width='' alt='Glide Placeholder Code' />

GIF created with [ScreenToGif](https://www.screentogif.com/) for Windows

## Notes

Describe any challenges encountered while building the app.
- Forgot how to figure out the serialized names for JSON. Took a bit too long to remember.
- Could not figure out an elegant way to nicely resize images in landscape mode without distorting the image.

## License

    Copyright [2023] [Adam Ramsey]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.