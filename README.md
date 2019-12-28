# Focusable Stage Example #

This example is a demo on how the Focusable Stage behaves in action.

### How to use ###

 1. Replace `Stage` with `FocusableStage`:
 
     `Stage stage = new Stage(viewport);` --> `FocusableStage stage = new FocusableStage(viewport);`
 2. Just as you add `Actor`s into a `Table`, add `Actor`s that you wish to have focus capabilities:
 
        stage.addFocusableActor(new TextButton("button 1", skin), 3); // 3 signifies the colspan of the Actor; default is 1 if you omit it
        stage.addFocusableActor(new TextButton("button 2", skin));    // Uses 1 colspan because the second argument was omitted
        stage.row(); // Used to signify the end of a row just like `Table`s
 3. Optionally, use `setFocusedActor` to focus a particular `Actor`:
  
        stage.setFocusedActor(textbutton3);
        
 ### Supported keyboard inputs ###
 
  - TAB             for focusing the next Actor
  - SHIFT + TAB     for focusing the previous Actor
  - LEFT            for focusing the previous Actor provided it isn't busy
  - RIGHT           for focusing the next Actor provided it isn't busy
  - UP              for focusing the above Actor provided it isn't busy
  - DOWN            for focusing the below Actor provided it isn't busy
  - Enter or Space  for pressing the currently focused Actor provided it isn't busy