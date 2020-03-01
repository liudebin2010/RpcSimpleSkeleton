[["java:package:com.m51das.ice.sv"]]
module book{
    struct Message{
        string name;
        int type;
        bool valid;
        double price;
        string content;
    };

    interface OnlineBook{
        Message bookTick(Message msg);
    };
};