package UZ.H4CK3R_1;

import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Buttons {
    private Message message;
    private Long chatId;

    public Buttons(Message message) {
        this.message = message;
        chatId = 977753033L;
    }


    private SendMessage sendMessage = new SendMessage();
    private SendDocument sendDocument = new SendDocument();
    private SendPhoto sendPhoto = new SendPhoto();

    public SendMessage menuRegistration() {
        KeyboardButton sendContact = new KeyboardButton();
        sendContact.setText("Kontaktni yuborish");
        sendContact.setRequestContact(true);

        KeyboardRow row = new KeyboardRow();
        row.add(sendContact);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(rowList);
        markup.setResizeKeyboard(true);
        sendMessage.setText("Kontakt yuborish tugmasini bosing");
        sendMessage.setReplyMarkup(markup);
        sendMessage.setChatId(message.getChatId());
        sendMessage.setReplyMarkup(markup);
        return sendMessage;
    }

    public SendMessage menu() {
        KeyboardButton information = new KeyboardButton();
        information.setText("\uD83D\uDCCB Yandex haqida ma'lumot");

        KeyboardButton userInformation = new KeyboardButton();
        userInformation.setText("\uD83D\uDC64 Mening ma'lumotlarim");

        KeyboardButton howManyPeople = new KeyboardButton();
        howManyPeople.setText("\uD83D\uDC65 Bot foydalanuvchilar soni");

        KeyboardButton taxiOrder = new KeyboardButton();
        taxiOrder.setText("\uD83D\uDE95 Buyurtma qilish");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(information);
        row1.add(userInformation);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(howManyPeople);
        row2.add(taxiOrder);


        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setKeyboard(rowList);
        sendMessage.setChatId(message.getChatId());

        sendMessage.setChatId(message.getChatId());
        sendMessage.setText("Buyruqlardan birini tanlang.");
        sendMessage.setReplyMarkup(markup);

        return sendMessage;
    }

    public SendDocument botAdmin() {
        InputFile file = new InputFile(new File("number.txt"));
        if (chatId == 977753033L) {
            sendMessage.setText("admin1234");
            sendMessage.setChatId(chatId);
            sendDocument.setDocument(file);
            sendDocument.setChatId(chatId);
        }
        return sendDocument;
    }

    public SendPhoto information() {
        InputFile inputFile = new InputFile(new File("src/main/resources/taxi.jpg"));
        sendPhoto.setCaption("Bizning Yandex botimizga qiziqish bildirganingizdan juda hursandmiz marhamat ma'lumotlar bilan tanishishingiz mumkin!\n" + "\n" + "\uD83D\uDE95Yandex Taxi boti orqali, foydalanuvchilar transport buyurtma qila olishadi. Buyurtma qilish uchun kerakli ma'lumotlarni kiritish, manzilingizni yozib, tez-tez qulay narxlarni ko'rish imkoniyati mavjud.\n" + "\uD83D\uDCB8To'lov variantlari: Foydalanuvchilar, yo'lovchiga ko'ra, naqd pul, bank kartasi yoki boshqa elektron to'lov variantlari orqali to'lovni amalga oshirishlari mumkin.\n" + "Bonuslar va chegirmalar: Ba'zi hollarda Yandex.Taxi, bonuslar, chegirmalar va takliflar taklif etishi mumkin.\n" + "\n" + "Android uchun:\n" + "https://play.google.com/store/apps/details?id=ru.yandex.taxi\n" + "\n" + "iPhone uchun:\n" + "https://apps.apple.com/app/id472650686");


        KeyboardButton back = new KeyboardButton();
        back.setText("Ortga ↩\uFE0F");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(back);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setKeyboard(rowList);
        sendMessage.setText("\uD83D\uDCCB Yandex haqida ma'lumot");
        sendMessage.setChatId(message.getChatId());
        sendPhoto.setPhoto(inputFile);
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setReplyMarkup(markup);
        return sendPhoto;
    }

    public void back() {
        KeyboardButton back = new KeyboardButton();
        back.setText("Ortga ↩\uFE0F");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(back);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setKeyboard(rowList);
        sendMessage.setChatId(message.getChatId());
        sendMessage.setReplyMarkup(markup);
    }

    public SendMessage botUserInformation() {

        KeyboardButton back = new KeyboardButton();
        back.setText("Ortga ↩\uFE0F");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(back);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setKeyboard(rowList);


        sendMessage.setText("Sizning ma'lumotlaringiz");
        sendMessage.setChatId(message.getChatId());
        sendMessage.setReplyMarkup(markup);
        return sendMessage;
    }

    public SendMessage userNameAndLastName(String getPHONE) {
        String firstName = message.getFrom().getFirstName();
        String lastName = message.getFrom().getLastName();
        if (lastName == null) {
            sendMessage.setText("\nIsmi: " + firstName + "\n" + "Sizning raqamingiz " + getPHONE);

        } else {
            sendMessage.setText("\nIsm: " + firstName + "\nFamiliya: " + lastName + "\nSizning raqamingiz " + getPHONE);
        }
        return sendMessage;
    }

    public SendMessage botUsers() {
        KeyboardButton back = new KeyboardButton();
        back.setText("Ortga ↩\uFE0F");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(back);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setKeyboard(rowList);
        sendMessage.setText("Assalomu Alaykum" + "\n" + "Ushbu bot foydalanuvchilari soni " + myRandom(7, 50) + " ta");
        sendMessage.setChatId(message.getChatId());
        sendMessage.setReplyMarkup(markup);
        return sendMessage;
    }


    public SendMessage userOrder() {
        sendMessage.setText("Manzilingizni kiriting");
        sendMessage.setChatId(message.getChatId());
        back();
        return sendMessage;
    }

    public SendMessage tarif() {


        KeyboardButton start = new KeyboardButton();
        start.setText("Start");

        KeyboardButton standart = new KeyboardButton();
        standart.setText("Standart");

        KeyboardButton comfort = new KeyboardButton();
        comfort.setText("Comfort");

        KeyboardButton business = new KeyboardButton();
        business.setText("Business");


        KeyboardRow row1 = new KeyboardRow();
        row1.add(start);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(standart);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(comfort);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(business);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setKeyboard(rowList);
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText("Tariflardan birini tanlang");
        sendMessage.setReplyMarkup(markup);


        return sendMessage;
    }

    public SendMessage starTarif(String joy, String getPhone) {
        sendMessage.setText("Hurmatli mijoz buyurtmangiz qabul qilindi!\n" + "\n" + "✅Tarif: START\n" + "\uD83D\uDE95Avtomobil: SPARK\n" + "\uD83D\uDE94Raqam: " + "01|A" + myRandom(100, 999) + "JA\n" + "\uD83D\uDCCDSizning manzilingiz: " + joy + ".\n" + "\uD83D\uDCB8Buyurtma narxi: " + myRandom(10000, 100000) + " UZS\n" + "☎\uFE0FSizning raqamingiz: " + getPhone + "\n" + "\uD83C\uDF89Buyurtmaniz uchun tashakkur. Kuningiz hayirli o'tsin. \n" + "\uD83C\uDF99Sizga tez orada hodimlarimiz a'loqaga chiqadi.");
        sendMessage.setChatId(message.getChatId());

        return sendMessage;
    }

    public SendMessage standartTarif(String joy, String getPhone) {
        sendMessage.setText("Hurmatli mijoz buyurtmangiz qabul qilindi!\n" + "\n" + "✅Tarif: STANDART\n" + "\uD83D\uDE95Avtomobil: NEXIA 1\n" + "\uD83D\uDE94Raqam: " + "01|A" + myRandom(100, 999) + "JA\n" + "\uD83D\uDCCDSizning manzilingiz: " + joy + ".\n" + "\uD83D\uDCB8Buyurtma narxi: " + myRandom(10000, 100000) + " UZS\n" + "☎\uFE0FSizning raqamingiz: " + getPhone + "\n" + "\uD83C\uDF89Buyurtmaniz uchun tashakkur. Kuningiz hayirli o'tsin. \n" + "\uD83C\uDF99Sizga tez orada hodimlarimiz a'loqaga chiqadi.");
        sendMessage.setChatId(message.getChatId());

        return sendMessage;
    }

    public SendMessage comfortTarif(String joy, String getPhone) {
        sendMessage.setText("Hurmatli mijoz buyurtmangiz qabul qilindi!\n" + "\n" + "✅Tarif: COMFORT\n" + "\uD83D\uDE95Avtomobil: COBALT\n" + "\uD83D\uDE94Raqam: " + "01|A" + myRandom(100, 999) + "JA\n" + "\uD83D\uDCCDSizning manzilingiz: " + joy + ".\n" + "\uD83D\uDCB8Buyurtma narxi: " + myRandom(10000, 100000) + " UZS\n" + "☎\uFE0FSizning raqamingiz: " + getPhone + "\n" + "\uD83C\uDF89Buyurtmaniz uchun tashakkur. Kuningiz hayirli o'tsin. \n" + "\uD83C\uDF99Sizga tez orada hodimlarimiz a'loqaga chiqadi.");
        sendMessage.setChatId(message.getChatId());

        return sendMessage;
    }

    public SendMessage businessTarif(String joy, String getPhone) {
        sendMessage.setText("Hurmatli mijoz buyurtmangiz qabul qilindi!\n" + "\n" + "✅Tarif: BUSINESS\n" + "\uD83D\uDE95Avtomobil: EQUONIX\n" + "\uD83D\uDE94Raqam: " + "01|A" + myRandom(100, 999) + "JA\n" + "\uD83D\uDCCDSizning manzilingiz: " + joy + ".\n" + "\uD83D\uDCB8Buyurtma narxi: " + myRandom(10000, 100000) + " UZS\n" + "☎\uFE0FSizning raqamingiz: " + getPhone + "\n" + "\uD83C\uDF89Buyurtmaniz uchun tashakkur. Kuningiz hayirli o'tsin. \n" + "\uD83C\uDF99Sizga tez orada hodimlarimiz a'loqaga chiqadi.");
        sendMessage.setChatId(message.getChatId());
        return sendMessage;
    }


    public int myRandom(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
