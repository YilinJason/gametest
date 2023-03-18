package com.mygdx.game.Screens;

//import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
//import com.mygdx.game.Building;
import com.mygdx.game.DefenseGames;
//import com.mygdx.game.MyRunnable;

//import javax.xml.soap.Text;

public class GameOverScreen implements Screen {

    DefenseGames game;
    Texture backGround;
    Texture building;
    Texture Button;
    Texture word;
    Music backGroundMusic;
    //private Thread myThread1;
    //private Thread myThread2;
    //private Thread myThread3;



    public GameOverScreen(DefenseGames game){
        this.game=game;
        backGround = new Texture("gameOver.png");
        building = new Texture("Fortress.png");
        backGroundMusic = Gdx.audio.newMusic(Gdx.files.internal("gameover.wav"));
        //Button = new Texture("home-button.png");
        word = new Texture("OverTxt.png");

    }
    @Override
    public void show() {
        // Play the BGM
        backGroundMusic.setVolume(0.2f);
        backGroundMusic.play();
    }

    @Override
    public void render(float delta) {

        game.batch.begin();
        game.batch.draw(backGround,0,0);
        game.batch.draw(building,1000,0,400,250);
        //myThread1 = new Thread(new MyRunnable(740,delta,game));
        //myThread2 = new Thread(new MyRunnable(670,delta,game));
        //myThread3 = new Thread(new MyRunnable(600,delta,game));
        //myThread1.start();
        //myThread2.start();
        //myThread3.start();
        game.batch.draw(word,Gdx.graphics.getWidth()/4.f,Gdx.graphics.getHeight()/2.f);
        if(Gdx.input.getX() > DefenseGames.windowsWidth/3.f && Gdx.input.getX() < DefenseGames.windowsWidth/3.f + 170
        && DefenseGames.windowsHeight - Gdx.input.getY() > DefenseGames.windowsHeight/4.f &&
                DefenseGames.windowsHeight- Gdx.input.getY() < DefenseGames.windowsHeight/4.f + 100){
            Button = new Texture("home-button1.png");
            game.batch.draw(Button,DefenseGames.windowsWidth/3.f,DefenseGames.windowsHeight/4.f,200,80);
            if (Gdx.input.isTouched()){
                game.setScreen(new MenuScreen(game));
            }
        }
        else{
            Button = new Texture("home-button.png");
            game.batch.draw(Button,DefenseGames.windowsWidth/3.f,DefenseGames.windowsHeight/4.f,200,80);
        }
        //game.batch.draw(Button,Gdx.graphics.getWidth()/3.f,Gdx.graphics.getHeight()/4.f,200,80);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}