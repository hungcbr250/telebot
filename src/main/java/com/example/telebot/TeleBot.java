package com.example.telebot;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
@Component
@EnableScheduling
public class TeleBot extends TelegramLongPollingBot {
    private final String BOT_TOKEN = "7232195464:AAGPVWnHP4mHASy09YS5yjti_B4nU71jk6g";
    private final String CHAT_ID = "-4048999942";
    private final String MESSAGE = "Chào a Hưng đẹp trai";
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new TeleBot());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    @Scheduled(cron ="0/30 * * * * *" )
    private void sendMessage() {
        SendMessage message = new SendMessage();
        message.setChatId(CHAT_ID);
        message.setText(MESSAGE);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onUpdateReceived(Update update) {
        // Không làm gì khi nhận update
    }
    @Override
    public String getBotUsername() {
        return "hungCris7";
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}
