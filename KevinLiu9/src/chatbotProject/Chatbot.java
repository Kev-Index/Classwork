package ChatBot;

public class Chatbot {

	private String username;
	private Topic bensTopic;
	private boolean chatting;
	
	public Chatbot() {
		bensTopic = new ChatBen();
		username = "unkown user";
		chatting = true;
	}
	
	public void startTalking() {
		ChatbotMain.print("Welcome to chatbot! whats your name?");
		username = ChatbotMain.getInput();
		
		while(chatting) {
			ChatbotMain.print("What do you want to talk about?");
			String response = ChatbotMain.getInput();
			chatting = true;
			
			if(bensTopic.isTrrigered(response)) {
				chatting = false;
				bensTopic.startChatting(response);
			}else {
				ChatbotMain.print("I'm sorry I don't undestand.");
				
			}
		}
	}

}
