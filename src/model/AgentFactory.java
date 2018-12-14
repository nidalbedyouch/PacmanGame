package model;

public class AgentFactory {
   public static Agent createPacman(PositionAgent position){
	   return new Agent(Agent.Type.Pacman,position);
   }
   
   public static Agent createGhost(PositionAgent position){
	   return new Agent(Agent.Type.Fantome,position);
   }
}
