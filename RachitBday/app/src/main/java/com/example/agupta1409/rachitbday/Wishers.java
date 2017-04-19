package com.example.agupta1409.rachitbday;

import com.example.agupta1409.rachitbday.db.Table;

import java.util.ArrayList;

/**
 * Created by a.gupta1409 on 17-07-2016.
 */
public class Wishers {

    private static ArrayList<Person> newList = new ArrayList<>();

    public static class Person {
        String name;
        int image;
        private int flag;
        String birthdayMessage;

        public Person(String name, int image, int flag, String birthdayMessage) {
            this.name = name;
            this.image = image;
            this.flag = flag;
            this.birthdayMessage = birthdayMessage;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }
    }

    public static ArrayList<Person> getList() {

        newList.add(new Person("Ria",R.drawable.riaimage,0,"Ranchoooo \uD83D\uDE0D\uD83D\uDE0D\uD83D\uDE0D\uD83D\uDE0D\n" +
                "\n" +
                "Happy birthday aalsi bestie, oh sorry, dps bestie!!! \uD83C\uDF89\uD83C\uDF82\uD83C\uDF8A\n" +
                "\n" +
                "Dekh hum Delhi quota wale Moradabad toh aa nahi paayenge toh apne dil mein tujhe yaad rakhke tujhse August mein badi wali treat lenge don't worry \uD83D\uDE0A\uD83D\uDE0A\n" +
                "\n" +
                "You're a great guy and I'm glad to have had the chance to know you. Meri bakwas sunne ke liye and advice dene ke liye thank you. Tu best hai yaar tere saath bohot mazze aate hai \uD83D\uDE0D\uD83D\uDE0D\n" +
                "\n" +
                "Happy birthday once again and I hope all your wishes come true and you have a great year ahead. Love you Rancho ❤\uD83D\uDE18\n" +
                "\n" +
                "PS: Apoorvi committed ho gayi \uD83D\uDE02\uD83D\uDE02"));

        newList.add(new Person("Mansi", R.drawable.mansiimage, 0,
                "Rancho pancho..tu mera favourite hai..tujhe sab pata hai mere baare mai aur mujhe tere..and there are somethings u have promised me..you ll fulfill that mister warna bahot punches parenge..love you so much kutte..you are my all time..har weekend..har friday dinner bc..tu mera constant hai mann..par zyada udna matt..aur zyada marna matt..ab toh juniors bhi aa jayenge..mai jab tujhse milungi toh ek surprise dungi..abi ke liye itna hi...a very happy happy birthday \uD83D\uDE18\uD83D\uDE18\uD83D\uDE18"));

        newList.add(new Person("Rajat",R.drawable.rajatimage,0,
                "Yoo Ranchooo!!\n" +
                        "Happy Birthday Bro! 20 saal ka ho gaya. Yaha Rohan ka bachpan chalra hai aur tu budha ho gaya abhi se. " +
                        "I remember jab first time tu mila tha. I hope me hi tha na poore SMMH me jisse tu sabse pehle mila tha? " +
                        "Rammurti ki class me. You told me tere 250 the aur tu RKP se he. Starting me tu kitaa shy shy sa tha. nd " +
                        "then tujhe hostel mil gaya nd our friendship started. lol 2nd sem to humne poora time saath me spend kiya he." +
                        " Hostel me ek doosre ke upar lete rehte the. Exam ke time padhe to the nhi kabhi idhar udhar hi dhyan rehta" +
                        " tha. IPL me, Vijender ki fights, Foodpanda ka Chicken!, Icetea, Bigbasket ka wo offer, Top Ramen, kya kya " +
                        "kiya hai! nd lol tere jokes! kabhi kabhi itte mast ho jaate hai! wo Ishan ke post pe and lol mess me \"" +
                        "isse bhi khaya ja sakta he\". nd haan lol saath me Rohan ko IGNORE karna. nd jab tere ghar se call aate " +
                        "the. Aunty ke kaise Bhola sa Bacha ban jata thaa. Looking forward to more such memories with you! Never " +
                        "change bro. aisa hi rahiyo mast saaa. Happy Birthday Future Roomie :*"));

        newList.add(new Person("Tanveer",R.drawable.tanveerimage,0, Table.TANVEER_MSG));

        newList.add(new Person("Pavana",R.drawable.pavanaimage,0,"Happy birthdayy Rachit !!!\n" +
                "I still remember how we met for the first tym.\n" +
                "Mujhe practical karna bilkul   pasand nhi hai..so mujhe bass ek aisa partner chahiye tha jo saara ka saara khud karr de.\n" +
                "N then you came. Tune bola ki tu 12th me class ka woh bachcha tha jo saare practicals easily karr leta tha. And believe me mai itni khush hui thii ki.\n" +
                "Fir hum electrical me bhi lab partners bann gye.!!!\n" +
                "And ek din tu mere saath ruka tha bahut der windpoint par kyuki mujhe basketballke liye jaana tha 5:30 aur mere saath koi nhi tha uss tym.\n" +
                "Itna helping and caring friend maine aaj tak nhi dekha. Even though tu mujhe bahut maarta tha starting me....but still I love youu sooo much.\n" +
                "And mere birthday parr bhii wohh chart wala idea tera hi tha ( aisa maine suna hai )\n" +
                "...toh uske liye bhi thanks!!\n" +
                "Chal Happy birthday! !!!\n" +
                "Love you\uD83D\uDE18\uD83D\uDE18\uD83D\uDE18"));

        newList.add(new Person("Tuba",R.drawable.tubaimage,0,"Rancho\uD83C\uDF82 ka badday aaya\uD83C\uDF82.." +
                "ranchoo\uD83C\uDF82 oye oye oye. Rancho\uD83C\uDF82 da badday. Yar ek ritual hai k jb we wish birthday to people, " +
                "we day a few realities about them and always in a good way to sunn tu na sabse down to earth hai apne grp pe, " +
                "tu dusro ki tarah moody nhi hai, you remember our first meeting in metro, acha hua tujhse mili thi, tb b bada " +
                "sweet sa laga tha aur ab b hai. Aur haan wese to tu bekar sa hi hai but teri smile bht happening si lagti hai. " +
                "Oye jb me moradabad aungi to milenge pakka\uD83D\uDE18"));

        newList.add(new Person("Stuti",R.drawable.stutiimage,0,"happy birthday rachit\n" +
                "wish u miles of smiles in the coming years .\n" +
                "enjoy ur day with all of the pleasures it has in store for you !!"));

        newList.add(new Person("Aayush",R.drawable.aayushimage,0,"\n" +
                "Happy Budday Muradabad ke stud or shall i call you SIR ? \uD83D\uDE02\n" +
                "You are the craziest and coolest friend of mine. \n" +
                "P.S. don't take it seriously \n" +
                "I always wanted a roommate like you \n" +
                "Cool about everything and enjoying each and every moment of your life. \n" +
                "Some people love their life but you make others love their life. \n" +
                "I feel ecstatic to say that The Great Rachit Garg is my friend. \n" +
                "Thanks for being a friend who is always available for me. \n" +
                "Happy Birthday Bro"));

        newList.add(new Person("Ravi",R.drawable.raviimage,0,"Happy b'dayy rachhoo.. \uD83C\uDF82\uD83C\uDF89\uD83C\uDF8A\n" +
                "Miss u buddy.. Aur teri wo sbse alag zor ki hasi bhi.. \uD83D\uDE1B\uD83D\uDE0B\n" +
                "Stay blessed bro , hmesha aise hi rhiyo .. And hmesha khush reh\uD83D\uDE00\uD83D\uDE01\n" +
                "GPL teri due h..\uD83D\uDE0B\uD83D\uDE09\n" +
                "Once again a very-very happy b'day bro.. \uD83D\uDE18"));

        return newList;
    }

}
