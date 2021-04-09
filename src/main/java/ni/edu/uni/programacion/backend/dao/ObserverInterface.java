
package ni.edu.uni.programacion.backend.dao;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.io.IOException;
import  java.util.Observable;
import java.util.Observer;
import ni.edu.uni.programacion.backend.pojo.Vehicle;
import java.util.Collection;

public interface ObserverInterface {

public void update(Observer Vehicle);
Collection<Vehicle> findByStatus(String status) throws IOException;
public void setVehicle(Vehicle veh);
public void notifyUpdate(Message m);

    





}
