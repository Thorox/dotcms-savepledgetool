package edu.pittstate.viewtools;

import org.apache.velocity.tools.view.context.ViewContext;
import org.apache.velocity.tools.view.servlet.ServletToolInfo;

public class PostToolInfo extends ServletToolInfo {

    @Override
    public String getKey () {
        return "savepledge";
    }

    @Override
    public String getScope () {
        return ViewContext.APPLICATION;
    }

    @Override
    public String getClassname () {
        return SavePledgeTool.class.getName();
    }

    @Override
    public Object getInstance ( Object initData ) {

        SavePledgeTool viewTool = new SavePledgeTool();
        viewTool.init( initData );

        setScope( ViewContext.APPLICATION );

        return viewTool;
    }

}
