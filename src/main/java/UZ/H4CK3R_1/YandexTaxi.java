package UZ.H4CK3R_1;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class YandexTaxi extends TelegramLongPollingBot {

    private String STATE = "";
    private String PHONE = "";

    private String joy;
    String getPHONE;


    private State STATE1 = State.INFORMATION;

    public String getBotUsername() {
        return Constants.BOT_NAME;
    }

    public String getBotToken() {
        return Constants.TOKEN;
    }


    @Override
    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();

        String text = message.getText();
        Buttons buttons = new Buttons(update.getMessage());
        if (update.hasMessage()) {
            if (message.hasText()) {
                if (STATE.equals("buyurtma")) {
                    joy = message.getText();
                    myExecute(buttons.tarif());
                    STATE = "";
                }
                if (text.equalsIgnoreCase("/start")) {
                    myExecute(buttons.menuRegistration());
                } else if (text.equals("\uD83D\uDCCB Yandex haqida ma'lumot")) {
                    myExecute(buttons.information());
                    STATE1 = State.INFORMATION;
                } else if (text.equalsIgnoreCase("\uD83D\uDC64 Mening ma'lumotlarim")) {
                    myExecute(buttons.botUserInformation());
                    myExecute(buttons.userNameAndLastName(getPHONE));
                } else if (text.equalsIgnoreCase("\uD83D\uDC65 Bot foydalanuvchilar soni")) {
                    myExecute(buttons.botUsers());
                    STATE1 = State.BOT_USERS;
                } else if (text.equalsIgnoreCase("\uD83D\uDE95 Buyurtma qilish")) {
                    STATE = "buyurtma";
                    STATE1 = State.USER_ORDER;
                    myExecute(buttons.userOrder());
                } else if (text.equals("Start")) {
                    myExecute(buttons.starTarif(joy, getPHONE));
                    myExecute(buttons.menu());
                } else if (text.equals("Standart")) {
                    myExecute(buttons.standartTarif(joy, getPHONE));
                    myExecute(buttons.menu());
                } else if (text.equals("Comfort")) {
                    myExecute(buttons.comfortTarif(joy, getPHONE));
                    myExecute(buttons.menu());
                } else if (text.equals("Business")) {
                    myExecute(buttons.businessTarif(joy, getPHONE));
                    myExecute(buttons.menu());
                } else if (text.equals("admin1234")) {
                    myExecute(buttons.botAdmin());
                } else if (text.equalsIgnoreCase("Ortga ↩\uFE0F")) {
                    if (STATE1.equals(State.INFORMATION)) {
                        myExecute(buttons.menu());
                    } else if (STATE1.equals(State.USER_INFORMATION)) {
                        myExecute(buttons.menu());
                    } else if (STATE1.equals(State.BOT_USERS)) {
                        myExecute(buttons.menu());
                    } else if (STATE1.equals(State.USER_ORDER)) {
                        myExecute(buttons.menu());
                    }


                }


            } else if (message.hasContact()) {
                Contact contact = update.getMessage().getContact();
                getPHONE = contact.getPhoneNumber().toString();
                PHONE = contact.getPhoneNumber();

                StringBuilder buffer = new StringBuilder();
                try {
                    File file = new File("number.txt");

                    if (!file.exists()) {
                        file.createNewFile();
                    }

                    FileReader reader = new FileReader(file);

                    int character;
                    while ((character = reader.read()) != -1) {
                        buffer.append((char) character);
                    }
                    reader.close();

                    FileWriter writer = new FileWriter(file);
                    writer.write(buffer.toString() + "\n" + "Name: " + contact.getFirstName() + "\nNumber: " + contact.getPhoneNumber().toString() + "\n");
                    writer.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                myExecute(buttons.menu());
            }

        }
    }


    public void myExecute(Object object) {
        try {
            if (object instanceof SendMessage) {
                execute((SendMessage) object);
            } else if (object instanceof SendPhoto) {
                execute((SendPhoto) object);
            } else if (object instanceof SendVideo) {
                execute((SendVideo) object);
            } else if (object instanceof SendDocument) {
                execute((SendDocument) object);
            } else if (object instanceof SendAudio) {
                execute((SendAudio) object);
            } else if (object instanceof SendLocation) {
                execute((SendLocation) object);
            } else if (object instanceof SendContact) {
                execute((SendContact) object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
