FROM node:14.16.0-alpine3.13
WORKDIR /app
ADD package.json package.json
ADD index.js index.js
RUN npm install --production
CMD ["node", "/app/index.js"]
