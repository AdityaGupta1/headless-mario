package com.devoxx4kids;

import com.devoxx4kids.species.SingleNetwork;
import org.junit.Test;

import java.io.IOException;

public class NetworkBuilderTest {

    @Test
    public void generateNetworkFromJson() throws IOException {
       SingleNetwork singleNetwork = NetworkBuilder.fromJSON("{\"hiddenNodes\":[{ \"id\": \"1234\",  \"inputNodes\":[{\"id\":\"bx1y14\" , \"weight\":0.988893},{\"id\":\"bx5y7\" , \"weight\":-0.407960},{\"id\":\"bx6y1\" , \"weight\":-0.663495},{\"id\":\"bx12y1\" , \"weight\":1.443816},{\"id\":\"bx7y2\" , \"weight\":-0.987017},{\"id\":\"857d2fd6-cb8a-4e1a-a901-2d6e019e63c4\" , \"weight\":-1.869070},{\"id\":\"bx9y5\" , \"weight\":1.067475}],\"outputNodes\": [ {\"id\":\"1234\" , \"weight\":1.105199}]}, { \"id\": \"b0bfe102-6f62-476a-8fee-f6c08194a2f5\",  \"inputNodes\":[{\"id\":\"bx13y0\" , \"weight\":0.873001},{\"id\":\"bx0y11\" , \"weight\":1.071582},{\"id\":\"bx5y0\" , \"weight\":-0.529732},{\"id\":\"bx11y0\" , \"weight\":-1.245276}],\"outputNodes\": [ {\"id\":\"b0bfe102-6f62-476a-8fee-f6c08194a2f5\" , \"weight\":1.552871}]}, { \"id\": \"a589f15c-c8d9-4ed5-a48e-bff21b877218\",  \"inputNodes\":[{\"id\":\"bx9y6\" , \"weight\":1.413134},{\"id\":\"bx2y12\" , \"weight\":1.630536},{\"id\":\"bx13y0\" , \"weight\":-1.294243},{\"id\":\"b0bfe102-6f62-476a-8fee-f6c08194a2f5\" , \"weight\":1.552871},{\"id\":\"bx12y14\" , \"weight\":-0.809380},{\"id\":\"bx1y13\" , \"weight\":0.702405}],\"outputNodes\": [ {\"id\":\"a589f15c-c8d9-4ed5-a48e-bff21b877218\" , \"weight\":1.426399}]}, { \"id\": \"857d2fd6-cb8a-4e1a-a901-2d6e019e63c4\",  \"inputNodes\":[{\"id\":\"bx12y1\" , \"weight\":1.183707}],\"outputNodes\": [ {\"id\":\"857d2fd6-cb8a-4e1a-a901-2d6e019e63c4\" , \"weight\":-1.869070}]}, { \"id\": \"564d6d5f-6b2a-413d-8af1-63431bcf5ec1\",  \"inputNodes\":[{\"id\":\"bx6y2\" , \"weight\":-0.386110}],\"outputNodes\": [ {\"id\":\"564d6d5f-6b2a-413d-8af1-63431bcf5ec1\" , \"weight\":0.625421}]}, { \"id\": \"f4544ca7-3784-49c7-91f3-949741c3cf73\",  \"inputNodes\":[{\"id\":\"bx6y5\" , \"weight\":0.832840},{\"id\":\"bx8y11\" , \"weight\":0.602642},{\"id\":\"bx12y3\" , \"weight\":-1.348049}],\"outputNodes\": [ {\"id\":\"f4544ca7-3784-49c7-91f3-949741c3cf73\" , \"weight\":-0.484598}]}]}");

        String x = singleNetwork.toJSONString();
        System.out.println(x);
        NetworkBuilder.fromJSON(x);
    }
}
