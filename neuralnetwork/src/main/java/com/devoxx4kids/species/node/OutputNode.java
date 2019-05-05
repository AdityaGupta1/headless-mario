package com.devoxx4kids.species.node;


import com.devoxx4kids.Constants;
import com.devoxx4kids.species.BlockReader;
import com.devoxx4kids.species.SingleNetwork;
import com.devoxx4kids.supermario.Block;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class OutputNode extends NonInputNode<Boolean> {
    public final int  button;
    public final String id;
    public OutputNode(Function<Double, Boolean> function, int  button) {
        super(function);
        this.button = button;
        this.level = 100;
        this.id = "O" + button;
    }

    // default just checks if the sigmoid of the input value is greater than 0.5
    public OutputNode( int button) {
        this(x -> Node.sigmoid(x) > Constants.pressThreshold, button);
    }

    @Override
    public OutputNode copy() {
        return new OutputNode(function, button);
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public double calculateValue(SingleNetwork network,BlockReader blockReader) {
        throw new RuntimeException("Output does not support calculate");
    }

    @Override
    public String toString() {
        return "OutputNode{" +
                "button=" + buttons.getValue(button)+
                '}';
    }
    
    static private enum buttons {
         A(0),
         B(1),
         Select(2),
         Start(3),
         Up(4),
         Down(5),
         Left(6),
         Right(7);

        int v;
        buttons(int v){
            this.v = v;
        }
         static Map<Integer,buttons> val = new HashMap<>();
        static{
            Arrays.stream(buttons.values()).forEach(e -> val.put(e.v,e));
        }

        static buttons getValue(int value){
            return val.get(value);
        }
    }
}
