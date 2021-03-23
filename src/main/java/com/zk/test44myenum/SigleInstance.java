package com.zk.test44myenum;

class Resource {
    public void useResource() {
        System.out.println("use Resource");
    }
}

public enum SigleInstance {
    GJR;
    private Resource resource;

    SigleInstance() {
        this.resource = new Resource();
    }

    public Resource getSigleInstance() {
        return resource;
    }

    public static void main(String[] args) {
        /**
         * 由于枚举中只有一个实例GJR所以构造函数只执行了一次
         */
        Resource resource = SigleInstance.GJR.getSigleInstance();
        resource.useResource();
    }
}
