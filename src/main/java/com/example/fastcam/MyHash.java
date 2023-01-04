package com.example.fastcam;

public class MyHash {
    public Slot[] hashTable;

    public MyHash(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String key;
        String value;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if(this.hashTable[address].key==key){
                this.hashTable[address].value=value;
            }else {
                Integer currAddress = address+1;
                while (this.hashTable[currAddress].key!=null){
                    if(this.hashTable[currAddress].key==key){
                        this.hashTable[currAddress].value=value;
                        return true;
                    }else {
                        currAddress++;
                        if(currAddress>=this.hashTable.length){
                            return false;
                        }
                    }
                }
                this.hashTable[currAddress] = new Slot(key,value);
                return true;
            }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if(this.hashTable[address].key==key){
                return this.hashTable[address].value;
            }else {
                Integer currAddress =address+1;
                while (this.hashTable[currAddress]!=null){
                    if(this.hashTable[currAddress].key==key){
                        return this.hashTable[currAddress].value;
                    }else {
                        currAddress++;
                        if(currAddress>=this.hashTable.length){
                            return null;
                        }
                    }
                }
                return null;
            }
        } else {
            return null;
        }
    }
}