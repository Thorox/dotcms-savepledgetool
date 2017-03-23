package edu.pittstate.viewtools;
import org.apache.velocity.tools.view.tools.ViewTool;

import com.dotmarketing.portlets.contentlet.model.Contentlet;
import com.dotmarketing.portlets.contentlet.business.ContentletAPI;
import com.dotmarketing.portlets.structure.model.Field;
import com.dotmarketing.portlets.structure.model.Field.FieldType;
import com.dotmarketing.portlets.structure.model.Structure;
import com.dotmarketing.cache.FieldsCache;
import com.dotmarketing.cache.StructureCache;
import com.dotmarketing.util.Logger;
import java.util.List;
import java.util.Map;
import com.dotmarketing.business.UserAPI;
import com.dotmarketing.business.APILocator;
/**
 * 
 * @author Jay Hodges
 *
 */
public class SavePledgeTool implements ViewTool {

	private boolean inited = false;
		
	/**
	 * Sets up the viewtool.  This viewtool should be application scoped.
	 */
	@Override
	public void init(Object initData) {
		Logger.info(this, "Save Pledge Viewtool Starting Up");
		
		// A flag to let the viewtool know we are good to go
		inited = true;
		
		Logger.info(this, "Save Pledge Viewtool Started");
	}
	
	public PostToolResponse save(String $pledgeStatus, String $patronName, String $address, String $city, String $state, String $zipcode, String $telephone, String $emailAddress, String $totalPledge, String $premium,  String $onAir,  String $useName,  String $contactMe,  String $favorites,  String $addlcomments) throws Exception {
		
		if(inited) {
			try{
				Structure s = StructureCache.getStructureByVelocityVarName("KrpsPledges");
 				if (s == null || s.getName() == null) {
					Logger.error(this,"KrpsPledges Not Found");
				}
				Contentlet c = new Contentlet();
				c.setStructureInode(s.getInode());
				ContentletAPI conAPI = APILocator.getContentletAPI();
				UserAPI userAPI = APILocator.getUserAPI();
				for (Field field : FieldsCache.getFieldsByStructureInode(s.getInode())) {
                        		if (field.getVelocityVarName().equals("pledgeStatus")) {
                                		conAPI.setContentletProperty(c, field, $pledgeStatus);
                        		}
                                        if (field.getVelocityVarName().equals("patronName")) {
                                                conAPI.setContentletProperty(c, field, $patronName);
                                        }
                                        if (field.getVelocityVarName().equals("address")) {
                                                conAPI.setContentletProperty(c, field, $address);
                                        }
                                        if (field.getVelocityVarName().equals("city")) {
                                                conAPI.setContentletProperty(c, field, $city);
                                        }
                                        if (field.getVelocityVarName().equals("state")) {
                                                conAPI.setContentletProperty(c, field, $state);
                                        }
                                        if (field.getVelocityVarName().equals("zipcode")) {
                                                conAPI.setContentletProperty(c, field, $zipcode);
                                        }
                                        if (field.getVelocityVarName().equals("telephone")) {
                                                conAPI.setContentletProperty(c, field, $telephone);
                                        }
                                        if (field.getVelocityVarName().equals("emailAddress")) {
                                                conAPI.setContentletProperty(c, field, $emailAddress);
                                        }
                                        if (field.getVelocityVarName().equals("totalPledge")) {
                                                conAPI.setContentletProperty(c, field, $totalPledge);
                                        }
                                        if (field.getVelocityVarName().equals("premium")) {
                                                conAPI.setContentletProperty(c, field, $premium);
                                        }
                                        if (field.getVelocityVarName().equals("onAir")) {
                                                conAPI.setContentletProperty(c, field, $onAir);
                                        }
                                        if (field.getVelocityVarName().equals("useNameInPublications")) {
                                                conAPI.setContentletProperty(c, field, $useName);
                                        }
                                        if (field.getVelocityVarName().equals("contactMe")) {
                                                conAPI.setContentletProperty(c, field, $contactMe);
                                        }
                                        if (field.getVelocityVarName().equals("favorites")) {
                                                conAPI.setContentletProperty(c, field, $favorites);
                                        }
                                        if (field.getVelocityVarName().equals("addlcomments")) {
                                                conAPI.setContentletProperty(c, field, $addlcomments);
                                        }
				}		
		                conAPI.checkin(c, userAPI.getSystemUser(), true, null);
        		} catch (Exception e) {
                		Logger.error(this,e.getMessage());
        		}
		}	
		return new PostToolResponse(999, null);
	}
	
}
