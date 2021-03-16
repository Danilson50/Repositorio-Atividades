FROM node:14.16.0-alpine3.13
WORKDIR /app
COPY package.json package.json
RUN npm install --production
COPY . .
CMD ["node", "/app/index.js"]
