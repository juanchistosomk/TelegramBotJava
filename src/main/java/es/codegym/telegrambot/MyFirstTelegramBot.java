package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;


public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "HERE USER TELEGRAM BOT ";
    public static final String TOKEN = "6400229369:AAEyOaHXlw_I6iemjawRgv8OFWfCSfIZ1mA";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí

        if( getMessageText().equals("/start") ){
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Hackear la nevera", "step_1_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("Tomar salchicha *20", "step_2_btn",
                            "Tomar pescado *20", "step_2_btn",
                            "Tomar lata pepinillos *20", "step_2_btn"
                            ));
        }

        if(getCallbackQueryButtonKey().equals("step_2_btn")){
            setUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Hackear al robot aspirador", "step_3_btn"
                    ));
        }

        if(getCallbackQueryButtonKey().equals("step_3_btn")){
            setUserGlory(30);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Enviar al robot aspirador a por comida +30", "step_4_btn",
                            "Dar paseo en robot aspirador +30", "step_4_btn",
                            "Huir del robot aspirador +30", "step_4_btn"
                    ));
        }


        if(getCallbackQueryButtonKey().equals("step_4_btn")){
            setUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Continuar para más nivel", "step_5_btn"
                    ));
        }


        if(getCallbackQueryButtonKey().equals("step_5_btn")){
            setUserGlory(40);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Acumula más fama +40", "step_6_btn"

                    ));
        }

        if(getCallbackQueryButtonKey().equals("step_6_btn")){
            setUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Transferir material +40", "step_7_btn",
                            "Hackear contraseña +40", "step_7_btn"
                    ));
        }

        if(getCallbackQueryButtonKey().equals("step_7_btn")){
            setUserGlory(40);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("Muy bien, continua a la fase final", "step_8_btn"

                    ));
        }

        if(getCallbackQueryButtonKey().equals("step_8_btn")){
            setUserGlory(0);
            sendTextMessageAsync(FINAL_TEXT);
        }


    // Messages
        /*
        if( getMessageText().contains("hola") ){
            sendTextMessageAsync("Hola, ¿Cuál es tu nombre?🚀🦾😊");
        }

        if( getMessageText().contains("mi nombre es") ){
            sendTextMessageAsync("Encantado de conocerte, soy *Gato* 😸");
        }
        */


    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}