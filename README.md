# javarush-telegrambot
JavaRush Telegram bot from community

# Deployment
The bot is deployed using Docker, which ensures convenience, portability, and dependency isolation. The deployment process is designed to facilitate smooth integration and continuous delivery.

### Prerequisites
Before deploying, ensure that you have the following installed on your machine:

- Docker
- Docker Compose (for orchestrating multiple containers)

# Environment Variables
The bot requires the following environment variables to operate:

- BOT_NAME — the name of the Telegram bot as registered with BotFather.
- BOT_TOKEN — the token for accessing the Telegram bot's HTTP API.

These variables should be specified in an .env file located in the same directory as your docker-compose.yml. 

Here's an example of what the .env file should contain:

* BOT_NAME=your_bot_name_here
* BOT_TOKEN=your_bot_token_here

**Warning:** Never commit the .env file to public repositories or distribute it by any other means as it contains sensitive data.

### Running the Bot

To run the bot, execute the following command in the project directory:

`docker-compose up`


### Stopping the Bot

To stop the bot, you can use the following command in the project directory:

`docker-compose down`
