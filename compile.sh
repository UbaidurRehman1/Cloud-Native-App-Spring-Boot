folders_to_compile=(netflix-eureka-naming-server netflix-zuul-api-gateway-server)
#iteration on above folders
for folder in "${folders_to_compile[@]}"
do
    dir="${folder}"
    cd "${dir}" || exit
    echo "Compiling ${dir}"
    mvn clean package -DskipTests
    cd .. || exit;
done