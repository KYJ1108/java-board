package org.example.douk;

public class Test {
    public static void main (String[] args){
        청둥오리 a청둥오리 = new 청둥오리();
        a청둥오리.날다();
        a청둥오리.헤엄치다();

        흰오리 a흰오리 = new 흰오리();
        a흰오리.날다();
        a흰오리.헤엄치다();

        고무오리 a고무오리 = new 고무오리();
        a고무오리.날다();
        a고무오리.헤엄치다();

        아수라오리 a아수라오리 = new 아수라오리();
        a아수라오리.날다();
        a아수라오리.헤엄치다();
    }
}
abstract class 날개아이템{
    abstract void 사용();
}
class 날개 extends 날개아이템{
    void 사용(){
        System.out.println("날다");
    }
}
class 고무날개 extends 날개아이템{
    void 사용(){
        System.out.println("못남");
    }
}
class 불사조 extends 날개아이템{
    void 사용(){
        System.out.println("불사조");
    }
}
abstract class 발아이템{
    abstract void 사용();
}
class 발 extends 발아이템{
    void 사용(){
        System.out.println("헤엄");
    }
}
class 고무발 extends 발아이템{
    void 사용(){
        System.out.println("둥둥");
    }
}
class 오리{
    날개아이템 a날개 = new 날개();
    발아이템 a발 = new 발();
    void 날다(){
        a날개.사용();
    }
    void 헤엄치다(){
        a발.사용();
    }
}
class 청둥오리 extends 오리{}
class 흰오리 extends  오리{}
class 고무오리 extends 오리{
    고무오리(){
        a날개 = new 고무날개();
        a발 = new 고무발();
    }
}
class 아수라오리 extends 오리{
    아수라오리(){
        a날개 = new 불사조();
        a발 = new 고무발();
    }
}