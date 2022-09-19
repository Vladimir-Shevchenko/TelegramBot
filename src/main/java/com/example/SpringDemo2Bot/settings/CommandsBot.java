package com.example.SpringDemo2Bot.settings;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandsBot extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return "September_19_bot";
    } //"SpringDemo2Bot"

    @Override
    public String getBotToken() {
        return "5391896121:AAEoLlKw2Q1QLHjMFk89QeOfzlG1lgcXz1M";
    }//"5356758910:AAFRbW595cCMTYHrcHwSAh1w-2dq_XeODCU"


    private void sendWithOutURL(Message message){
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("тык");
        button.setCallbackData("start1");

        List<InlineKeyboardButton> keyboardButtonRow = new ArrayList<>();
        keyboardButtonRow.add(button);

        List<List<InlineKeyboardButton>>  rowList = new ArrayList<>();
        rowList.add(keyboardButtonRow);

        keyboard.setKeyboard(rowList);

        try {
            execute(
                    SendMessage.builder()
                            .chatId(message.getChatId())
                            .parseMode("Markdown")
                            .text("Привіт, любімка!")
                            .replyMarkup(keyboard)
                            .build());
        }catch (TelegramApiException e){e.printStackTrace();}
    }

    @Override
    public void onUpdateReceived(Update update) {
if(update.hasMessage()&&update.getMessage().hasText()){
    String messageText = update.getMessage().getText();
    Message command = update.getMessage();
    long chatID = update.getMessage().getChatId();
    System.out.println("getMessage().toString():  "+update.getMessage().toString());
    switch (messageText){
        case "/start":
            startAnswer(command);
            break;

        default:
            try {
                 execute(SendMessage.builder()
                         .chatId(command.getChatId())
                         .parseMode("Markdown")
                         .text("Нихера не понял, но очень интересно!")
                         .build());
            }catch (TelegramApiException e){e.printStackTrace();}
            break;

    }
}
else if(update.hasCallbackQuery()){if(update.getCallbackQuery().getData().equals("start1")){
    //sendWithOutURL(update.getCallbackQuery().getMessage());
    try {
        execute(
                SendMessage.builder()
                        .chatId(update.getCallbackQuery().getMessage().getChatId())
                        .parseMode("Markdown")
                        .text("Таня я тебе люблю!!")
                        .build());
    }catch (TelegramApiException e){e.printStackTrace();}
}}
    }


    private void startAnswer(Message command) {
        sendWithOutURL(command);

    }
}
