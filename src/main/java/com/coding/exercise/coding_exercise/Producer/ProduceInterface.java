package com.coding.exercise.coding_exercise.Producer;

public interface ProduceInterface {
    public void sendToChannelOne(String msg);

    public void sendToChannelTwo(String msg);

    public void sendToChannelThree(String msg);

    public void sendToChannelFour(String msg);

    public void sendToChannelBackup(String msg);
}
