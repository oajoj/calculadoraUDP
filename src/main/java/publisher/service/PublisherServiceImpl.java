package publisher.service;

import publisher.util.PublisherUtil;

public class PublisherServiceImpl implements PublisherService{

    @Override
    public byte[] returnMathResult(String msg) {
        return PublisherUtil.doMath(msg);
    }
}
