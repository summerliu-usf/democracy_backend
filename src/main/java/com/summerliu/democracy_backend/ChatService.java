package com.summerliu.democracy_backend;

import java.util.List;

/**
 * Service class for managing chat conversations using LangChain4j and OpenAI APIs.
 */
public class ChatService {

    private OpenAIConversation conversation;

    public ChatService(String apiKey, String modelName) {
        this.conversation = new OpenAIConversation(apiKey, modelName);
    }

    public ChatService(String apiKey) {
        this(apiKey, "gpt-4o-mini");
    }

    public ChatService() {
        this("demo", "gpt-4o-mini");
    }

    /**
     * Sends a message with context and returns the response from the assistant.
     *
     * @param context System instructions for the assistant.
     * @param message The user's message.
     * @return The assistant's response.
     */
    public String sendMessage(String context, String message) {
        return conversation.askQuestion(context, message);
    }

    /**
     * Sends a message to an assistant with a given assistant ID and returns the response.
     *
     * @param apiKey      OpenAI API key.
     * @param context     System instructions for the assistant.
     * @param message     The user's message.
     * @param assistantId The assistant's ID.
     * @return The assistant's response.
     */
    public String sendMessageWithAssistantId(String apiKey, String context, String message, String assistantId) {
        return conversation.askQuestion(apiKey, context, message, assistantId);
    }

    /**
     * Generates sample questions based on the given context.
     *
     * @param context  The system instructions for the assistant.
     * @param count    The number of sample questions to generate.
     * @param maxWords The maximum word count per question.
     * @return A list of generated sample questions.
     */
    public List<String> generateSampleQuestions(String context, int count, int maxWords) {
        return conversation.generateSampleQuestions(context, count, maxWords);
    }

    /**
     * Generates sample questions based on the given context and assistant ID.
     *
     * @param apiKey      OpenAI API key.
     * @param context     The system instructions for the assistant.
     * @param assistantId The assistant's ID.
     * @param count       The number of sample questions to generate.
     * @param maxWords    The maximum word count per question.
     * @return A list of generated sample questions.
     */
    public List<String> generateSampleQuestionsWithAssistantId(String apiKey, String context, String assistantId, int count, int maxWords) {
        return conversation.generateSampleQuestions(apiKey, context, assistantId, count, maxWords);
    }

    /**
     * Resets the conversation, clearing all memory.
     */
    public void resetConversation() {
        conversation.resetConversation();
    }

    /**
     * Returns the entire conversation history as a string.
     *
     * @return The conversation history.
     */
    public String getConversationHistory() {
        return conversation.toString();
    }
}
