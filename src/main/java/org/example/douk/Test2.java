package org.example.douk;

public class Test2 {
    public static void main(String[] args){
        청둥1오리 a청둥오리 = new 청둥1오리();
        a청둥오리.날다();
        a청둥오리.헤엄치다();

        흰1오리 a흰오리 = new 흰1오리();
        a흰오리.날다();
        a흰오리.헤엄치다();

        고무1오리 a고무오리 = new 고무1오리();
        a고무오리.날다();
        a고무오리.헤엄치다();

        아수라1오리 a아수라오리 = new 아수라1오리();
        a아수라오리.날다();
        a아수라오리.헤엄치다();
    }
}
abstract class 날개들{
    abstract void 사용();
}
class 오리날개 extends 날개들{
    void 사용(){
        System.out.println("오리 날아유~");
    }
}
class 고무고무 extends 날개들{
    void 사용(){
        System.out.println("못날아유~");
    }
}
class 불날개 extends 날개들{
    void 사용(){
        System.out.println("불다유~");
    }
}
abstract class 발들{
    abstract void 사용();
}
class 오리발 extends 발들{
    void 사용(){
        System.out.println("수영중");
    }
}
class 고무 extends 발들{
    void 사용(){
        System.out.println("둥둥");
    }
}
class 오리들{
    날개들 a날개 = new 오리날개();
    void 날다(){
        a날개.사용();
    }
    발들 a발 = new 오리발();
    void 헤엄치다(){
        a발.사용();
    }
}
class 청둥1오리 extends 오리들{}
class 흰1오리 extends 오리들{}
class 고무1오리 extends 오리들{
    void 고무1오리(){
        a날개 = new 고무고무();
        a발 = new 고무();
    }
}
class 아수라1오리 extends 오리들{
    void 아수라1오리(){
        a날개 = new 불날개();
        a발 = new 고무();
    }
}