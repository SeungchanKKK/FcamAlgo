package com.example.fastcam;

public class MyHash {
    public Slot[] hashTable;

    public MyHash(Integer size){
        this.hashTable=new Slot[size];
    }

    public class Slot{
        String key;
        String value;
        Slot next;
        public Slot(String key,String value) {
            this.value = value;
            this.key =key;
            this.next = null;
        }
    }
    public Integer hashFunc(String key){
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if(hashTable[address]!=null){
            Slot prevSlot = this.hashTable[address];
            Slot findSlot = this.hashTable[address];
            while (findSlot!=null){
                if (findSlot.key.equals(key)){
                    this.hashTable[address].value= value;
                    return true;
                }else {
                    prevSlot= findSlot;
                    findSlot=findSlot.next;
                }
            }
            prevSlot.next= new Slot(key,value);
        }else {
            this.hashTable[address]=new Slot(key, value);
        }
        return true;
    }

    public String getData(String key){
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            Slot slot = this.hashTable[address];
            while (slot!=null){
                if (slot.key.equals(key)){
                    return slot.value;
                }else {
                    slot=slot.next;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        MyHash mainObject = new MyHash(20);
        mainObject.saveData("DaveLee", "01022223333");
        mainObject.saveData("fun-coding", "01033334444");
        mainObject.saveData("David", "01044445555");
        mainObject.saveData("Dave", "01055556666");
        System.out.println(   mainObject.getData("David"));
    }
}
