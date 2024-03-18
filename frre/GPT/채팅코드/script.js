document.addEventListener("DOMContentLoaded", function () {
    // 스크립트에서 필요한 동작 추가
    simulateChat();
});

function simulateChat() {
    setTimeout(function () {
        addChatBubble("Hi there!");
        showTypingIndicator();
    }, 1000);

    setTimeout(function () {
        addChatBubble("How are you?");
        hideTypingIndicator();
    }, 3000);

    // 추가적인 채팅 동작을 원하는대로 추가 가능
}

function addChatBubble(message) {
    const chatContainer = document.querySelector(".chat-container");
    const chatBubble = document.createElement("div");
    chatBubble.classList.add("chat-bubble");
    chatBubble.innerHTML = `<p>${message}</p>`;
    chatContainer.appendChild(chatBubble);
}

function showTypingIndicator() {
    const typingIndicator = document.querySelector(".typing-indicator");
    typingIndicator.style.display = "flex";
}

function hideTypingIndicator() {
    const typingIndicator = document.querySelector(".typing-indicator");
    typingIndicator.style.display = "none";
}
