#stage 1
FROM node:latest as node
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod

#stage 2
FROM nginx:alpine
COPY --from=node /app/dist/digital_honors_angular /usr/share/nginx/html

CMD ng serve --host 0.0.0.0 --port 4200