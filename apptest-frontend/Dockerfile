FROM nginx:1.13.3-alpine

RUN rm -rf /usr/share/nginx/html/*

COPY /dist /usr/share/nginx/html
COPY default.conf /etc/nginx/conf.d/default.conf

CMD ["nginx", "-g", "daemon off;"]
