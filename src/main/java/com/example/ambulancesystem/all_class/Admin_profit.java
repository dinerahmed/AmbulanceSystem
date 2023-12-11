package com.example.ambulancesystem.all_class;

public class Admin_profit {

    int daily,cumulative;

    public Admin_profit(int daily, int cumulative) {
        this.daily = daily;
        this.cumulative = cumulative;
    }

    public Admin_profit() {
        this.daily = 0;
        this.cumulative = 0;
    }

    public int getDaily() {
        return daily;
    }

    public void setDaily(int daily) {
        this.daily = daily;
    }

    public int getCumulative() {
        return cumulative;
    }

    public void setCumulative(int cumulative) {
        this.cumulative = cumulative;
    }


}
