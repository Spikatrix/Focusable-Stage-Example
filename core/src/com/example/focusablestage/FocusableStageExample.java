package com.example.focusablestage;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class FocusableStageExample extends ApplicationAdapter {
    private Skin skin;
    private FocusableStage stage;

    private TextButton[] buttons = new TextButton[10];
    private int buttonIndex = 0;
    private TextField[] textFields = new TextField[3];
    private int fieldIndex = 0;

    @Override
    public void create() {
        skin = new Skin(Gdx.files.internal("neon-ui.json"));

        stage = new FocusableStage(new ScreenViewport());

        Table table = new Table();
        table.center();
        table.setFillParent(true);

        for (int i = 0; i < 16; i++) {
            if (i == 4 || i == 6 || i == 13) {
                textFields[fieldIndex] = new TextField((i + 1) + ", " + (i + 2), skin);
                textFields[fieldIndex].setName("Sample textfield");
                textFields[fieldIndex].setAlignment(Align.center);

                table.add(textFields[fieldIndex]).colspan(2).pad(10f);
                stage.addFocusableActor(textFields[fieldIndex], 2);

                if (i == 6) {
                    table.row();
                    stage.row();
                }

                fieldIndex++;
                i++;
                continue;
            }

            buttons[buttonIndex] = new TextButton(String.valueOf(i + 1), skin);

            table.add(buttons[buttonIndex]).pad(10f).width(80f).height(60f);
            stage.addFocusableActor(buttons[buttonIndex]);

            if ((i + 1) % 4 == 0) {
                table.row();
                stage.row();
            }

            buttonIndex++;
        }

        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        super.resize(width, height);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
