package com.example.fastcam;

public class MyHash {
    public Slot[] hashTable;

    public MyHash(Integer size){
        this.hashTable=new Slot[size];
    }

    public class Slot{
        String key;
        String value;
        public Slot(String key,String value) {
            this.value = value;
            this.key =key;
        }
    }
    public Integer hashFunc(String key){
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if(hashTable[address]!=null){
            if (this.hashTable[address].key==key){
                this.hashTable[address].value=value;
                return true;
            }else {
                Integer currAddress = address + 1;
                while (this.hashTable[currAddress] != null) {
                    if (this.hashTable[currAddress].key == key) {
                        this.hashTable[currAddress].value = value;
                        return true;
                    } else {
                        currAddress++;
                        if (currAddress >= this.hashTable.length) {
                            return false;
                        }
                    }
                }
                this.hashTable[currAddress] = new Slot(key, value);
                return true;
            }
        }else {
            this.hashTable[address]=new Slot(key, value);
        }
        return true;
    }

    public String getData(String key){
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
           if(this.hashTable[address].key==key){
               return hashTable[address].value;
           }else {
               while (hashTable[address] != null){
                   if (hashTable[address].key== key){
                       return hashTable[address].value;
                   }else {
                       address++;
                       if (address >= this.hashTable.length) {
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

    public static void main(String[] args) {
        MyHash mainObject = new MyHash(20);
        mainObject.saveData("DaveLee", "01022223333");
        mainObject.saveData("fun-coding", "01033334444");
        mainObject.saveData("David", "01044445555");
        mainObject.saveData("Dave", "01055556666");
        System.out.println(    mainObject.getData("David"));
    }
}
