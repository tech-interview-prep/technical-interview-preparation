package leetcode_online_judge;

import utils.Utils;

import java.util.List;
import java.util.ArrayList;

public class WordSearch {
    /*
    Given a 2D board and a word, find if the word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
    horizontally or vertically neighboring. The same letter cell may not be used more than once.

    For example,
    Given board =

    [
      ["ABCE"],
      ["SFCS"],
      ["ADEE"]
    ]
    word = "ABCCED", -> returns true,
    word = "SEE", -> returns true,
    word = "ABCB", -> returns false.
    */
    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(board, word, new boolean[m][n], i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, String word, boolean[][] hasVisited, int i, int j, int wStart) {
        if (wStart == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(wStart) || hasVisited[i][j]) {
            return false;
        }
        hasVisited[i][j] = true;
        if (exist(board, word, hasVisited, i - 1, j, wStart + 1)
                || exist(board, word, hasVisited, i, j + 1, wStart + 1)
                || exist(board, word, hasVisited, i + 1, j, wStart + 1)
                || exist(board, word, hasVisited, i, j - 1, wStart + 1)) {
            return true;
        }
        hasVisited[i][j] = false;
        return false;
    }

    private static void test() {
        char[][] board = new char[][] {
                "abce".toCharArray(),
                "sfcs".toCharArray(),
                "adee".toCharArray()
        };

        Utils.printTestln(exist(board, "abcced"), true);
        Utils.printTestln(exist(board, "see"), true);
        Utils.printTestln(exist(board, "abcb"), false);
        Utils.printTestln(exist(getLargeBoard(), "oajgdkcokvfpdaslnmomrpgwitwdoku"), true);
        Utils.printTestln(exist(getLargeBoard2(), " lcpsvdhalttairlfa"), false);
    }
    
    public static void main(String[] args) {
        test();
    }
    
    
    private static char[][] getLargeBoard() {
        return new char[][] {
            "elxllvxegzmvgnhrypvagxrgwktiqnyuavfnsfsbgewnrferubrcykjwveenrfhtamhvtzwafspzxvqtwkxwwgttkzgdenzhcgcvhyxosonrjgmhsjeo".toCharArray(),
            "qxkcyqidehkipofwofmgtazfilocwuqotatstbvzkhhzvmxjrjrnlsutdixbdoqwqjolklkwstvpgsyzdropjikoriquygsqphcbuoxniucoodpruegg".toCharArray(),
            "mrudzkzxsupjbrmxgjkofpetutnoztwmmrrndtmwncfqtsnbdaplrvglptbqpycdpwrspdqehyudsjevjwictpnkkpbznfdebwysbpwjnsmfcscnqnqk".toCharArray(),
            "cdumuvojbtnepmxqdvbsopzskdfaqxkudhhxexhfqwkfkjxnezhuqgmamsbcrnxuwgsbdbgtxsaidxxiyfcplrpxlqccgzxchrdksmfpgfxkexudcysp".toCharArray(),
            "phnaarfisckztqllcqckxcubzqebpyqgifjkwosqqeplucyysajreftfwzgnazvkgeufsovisnvpptnkwybagwgeyotypokwteblsywmlrbbnrljrmlx".toCharArray(),
            "ltbjiujxjtvczwprvlfifhjsaubrjmpugsfqnopyjlcijrbgfgpkpacpvfhgtwczohrdxhbgudqfxroczdopdqeavliojkqarjdqshwomoujfinhnbws".toCharArray(),
            "tatoobfxmxzfidwbkupwjlgqtvxgxvzqyuhmxollnltvqpyalowwbepvcmdzkeriaauyohjducbktzkhpjdrpsorhrstykbykxwbeigzmhlihwpwhupw".toCharArray(),
            "pdoyxirvsuvfrsivcowqwiydgpbnmrlbwbbtkuqcomjfgrckgbaejzjrqkgcdrfctgxfcojqctvkkausbuymvhdmsjqxcwzxezchnmzrfxbrxvmapkmn".toCharArray(),
            "srbmcrleplcukgdzscszbtraofafpmujdvxfnjmcwoygubhpgzojuhkkmkrexmnchlkuuwzqmxyibhxhioqcvcmindmmrbozoyvkwuciscrvlqcteuxa".toCharArray(),
            "zlkmryyibmhqndcjzfutjnovdsokpomozyaqwyzxmipbnslnxhgguxbzpslegxsfxuytuztjhikvaxkzesgypjahdllllgticrexqxgzfqwiqghubpvq".toCharArray(),
            "bxxeilsvtleveksuhatotswjygfzvasyxrficxdvijtmtniaodrhvnswtxvrappxhuhjtlhduarqnzsdfjmcxeyscwlcldbszjetwnwspoiepbiukuzj".toCharArray(),
            "zxedtrfhuiburhpnulilbqqttypgsoptmvwhnbqhmuddbstygbjjtzcnzstsiknwgkgvnwczqgfuyysgbdqwfslemgyvrmtzwzujwyjoeqifoclrgdnl".toCharArray(),
            "ybrkhqhycbzyatjysspyizfycrrkwhxuiofpeoogrpeujosdijbtjhtlalxwsutciarpohvgxcaisulcgovpvrcxezwyvpafprufzqlysngmkroqfkfd".toCharArray(),
            "djchkyhfphkeafkbxxzrnfdxyrngdulgfnppowufdgkgnwhkvhbiogfpyuxdqkkvzbknygtdnfjadtnaaojqvqhvleydokzomldmsyrhfbhkuulwluoi".toCharArray(),
            "mwfzcddtoejcpmojnfqsiafewqchmtrypwytcdmqhxuwmkizrytcaygxqlgceabvwboyedqnamlowtnoujqujytajacnafkyizxoepbgcnvygkoatgxf".toCharArray(),
            "fqfqsjgsrqtzrsoxhpgjcbklnaljhkoobvetemovfjxwblwiccuffgssgddnqrbrmimtwcobllamywvbargfxyzdddttwwmjgbcddsgpegbeeyfernlo".toCharArray(),
            "nlutqnomlbxsczvhubwakaeoakvsxgiltcejrswdvtxzvshpvdrhfvygftafbisvnyeeqcjoygntawkycbfhwdpeyplaadvnbbttgdhelxzmtjkxmrfk".toCharArray(),
            "xwovozvocsdfwwzcbigphfbbqnacgfmdedbsewgjrjonhprlyzafediwsjyyqmeurfmwdufufvjnlcalbaqhfbdxkdxaqbxjgjfkgmglisavuagwcydh".toCharArray(),
            "zjglmeoeflomwtycigosyqnvrvttvydvhjgupwyvhmjgijiqpykqpzliugdpegmmsvihriezvnhfwpxoqhefgrpcxstbzgptbxaugfvduckrujhkqlry".toCharArray(),
            "cgcbyvczdusgttbbaweubqnvzufrfypjetkcrpcujwbcpeepakmddzycufubdlnhhzmyoqszmveezkvcwhfzheedjygnltwstiqjallngptizokxyrxh".toCharArray(),
            "vbkhbswomujhfbqfmduvsndtenrceojcrvlsnjizdriitbofekcxafseujgbzrdsmqmzzvbcmjlfkbnpnponvgrrszsrqxkcnwcmtdrgoenbfaquqgin".toCharArray(),
            "obegbxatumwkkawefpmvtzwaamvsudfjglrhirbffzpqbnwididyhazhowbjbguhslrcfujmtaewoaetkhtshsbwqdhrldzfqqixktkfuodkrhfboyvy".toCharArray(),
            "tzwjcfdpicvyufwgyinsyqcpxjtnioldnjmropjwtexnjvvjdicbygtxsmlacydsirlyjuxcausjrnvuyzxyhqwzehbhhebrymqhhnljjdvatqwtptrw".toCharArray(),
            "kpyqyzzggaxenpnwcyfneanzsjshdlgpbefzdhfjhfpuucszbamfcagvjycojkfmonmuurfbyvytxssysefvglqslugxfmjtbvpvpvypqwinpcohjtep".toCharArray(),
            "huhuporucbpfyfapayfsxpfostvbpcqywysnomjspbxnizfkxmcwbhktdiwukpuinmwdahxpiufqtkaswepxmbtrjrntghettcywjvlurqmkapfytwyh".toCharArray(),
            "xtyhklcruimqklmuixoaoamqprrlppsnitwsgalbjyrtldntadvqgijxbairpbgzwctccfdndwhozwjcafuipdfqdojurptptpryuxlztspvraztftbw".toCharArray(),
            "xipawyxpqqgjhyhbxvcsprpguozbicyhlpjjngbfzhrghakgvmzlgotafvbpxbwiqfugovlneetmfdscstnyijapebebdamthibxdnkhrgvylobdhqdr".toCharArray(),
            "zdgdhmhmmvfwdhtiwgpponozbrfkhkehommxzvjnqojvxfdvnvnbibclujxbubkiqzhpuqcngoievobijolrrnelxbptfzdvykkvaoigesmzgojpcwiw".toCharArray(),
            "kohjqwcvyfqwpctrqbxxukwcyiscecaqrizjgdgekydbawssaqpwcoycwseavftopuxvydckbhmddgxfypbadacbsjdpqwdhrccrhgbknpntynywcczf".toCharArray(),
            "ediymloeitlbwqsfwvqmlfhlshhujibnmjmavcffvsitiazhxptkuavnhfjtnlizuucpyhwuzenkgoredkoamkpvpyoejxeetgvspsoqydafsrjxdxxr".toCharArray(),
            "jmnandfwclcytyskqgaqldvdwebaeatppiqcoxaqidqdbintqnjcqfhnliprlijatbehyezihqlkaydtnpxgwevjpmdawmcppgwpmyxwokgqkmjzdghz".toCharArray(),
            "nckcqnenbgcqobfczeypohhavtcabjbomlsczwraewtszyxadxptgywdrydthehvqaaryrtdnmxoluoqsflaejevjhqroyoeaoxaiqdxdbmqxagrgtsm".toCharArray(),
            "fyhofyfvywbamyaupguujgkgisaqlscsqmhxmovmkwmxvotmungdvsmekmwxgzqylxvxlsjwpxvmnoyiegnzybfinchtdxroupnihygyvbkirksxqizq".toCharArray(),
            "jeaxiislfmbcdqkkoqjltvwkgqkyyjrkprjybbljpnlsfxfupqhildutweuwplgfepdgtqrkdedjbifsymalswfqdbmsmtxskcaftrqyvtjydoqddsox".toCharArray(),
            "pvnuwzmkumdhqfmjxcisvrtaijdneukvrxpqydavrfcilorktbeqvxrdjwqnqciibxyzcawuiacvrvfkxjashtvsqnfgpnqqmqrorokbqmwhibrhmuzv".toCharArray(),
            "nwndlumahesvvjmozwpqlnzvqrecndaabngmiuoryiptrbhtzylmlkjbdngqsgtttbhdvxxvfmpzpysozfdkrmovcunuciqxjzbgxaeemvdbtxruewhw".toCharArray(),
            "lvtnrgjtrzqcztjytpehkikfhcamahilcbyvjkoajgdkcokvfpdpznugrusubcffdgcpqqpbzuobkyypnbgmrbvkvngzqogvujkmbcpaydblcacrdjgw".toCharArray(),
            "kbjhqpiidpezyqnzudctgfgkhientkjfnupdmxorostmkgoflsasxgehqiumufrhainogbfuvyjfhzksrkmqsrxjztxuzodbxqpftwboxmuelgyetlxl".toCharArray(),
            "cwwdqtzpkfsjxjorfrfeebkrkjwduvqyrpdhkdyuiqffzvyhnglrhwitfgwbbpzteccohblrtqzvoxcbdpsnlcgsjftmuuhazkoinbaiuzdiyfjcvdpi".toCharArray(),
            "hxbscwfwtmwuyncnqewkfzuehfieizmswpkzorxheudejfszmomrpgvwmdawepobebassxbytgdeoxgansrcapboubnzsdazectzbvxxdabrzhrmblpc".toCharArray(),
            "cqswtfxmjznpbgofdmchodyolsaodrqfhlddqbrbaetekhjovlxmqvadncsqukxdvbimezpgfikssvinifzzabeqewiahgfejosnpitxqgpibzymexng".toCharArray(),
            "brwhqfhzlmdwcwjseerwkghofhalenrhgoowtvxgkbemxngdrzbehkuoruzyjrfrhuqcrnkdoosnbasuauahguwyqvwbodtvxjxrwhunvmaynvvprxwx".toCharArray(),
            "ssviqtmexfawqzpojkbgyehnzccqzbpttnelgqqfxsenrtbaffjgjqtkuycvbrpuevgnlyukqyxjsamxfvdqlzahzccawrwcmepzcmjukiecjqcqnhhy".toCharArray(),
            "ijfjojjkbgopmgrrsclclrhwhlowuvwdhdmvnyhqgvhsbyjtdxyoofmyqaukyrpfucchcjxiefaifmbijzyxgmvwnsjnjasfeupgfmojtprbdvlmwkjd".toCharArray(),
            "whblbkaklsrpogwvvmfodyrgvdsspexnnyzolzawurnkylgtynjdnbklecdtiagvahjljjjfdxrbkzwkohoeiypocujlwsiwbsimdrriqljbkhnbpbfz".toCharArray(),
            "buqgoztktbgvvohzibhymtzycnzrqetuajaoityeuhzqxirfjaexvfyyuzrnekhevhvecviwcjoarhhdklcftcfpczcillohujnwfxtjgjjzrrebejiz".toCharArray(),
            "lornpvvahkjbvwyattmbcvdtohwvqfwevnrkjpmsbwtwsrzomlppiskzchwuosyjisvtjhlkdeiwyhkkubbdwmeyvaujuvucnpxywiiapqypakbuldzh".toCharArray(),
            "rdfmfcxaxremickemsgbkeskouhcxijqorcttbvssceaeogsinwstofkkomjwxzkobgjcbbwdfyjvfcduyypofbztpipnicdlipqjqopynyvucbqcbht".toCharArray(),
            "gjsbacqpmutacisoagfavfwrixhmyrfgczhcezsqulsyvkoxrtyozugjtpxtgdzkegnihfbdstcpeqmxmklngtwzltstytedbrnjyomskohohvnvgaio".toCharArray(),
            "ueohziaacefdvsovjbnvrwlysyvaadoujedjnelriqwgkldtorqfnbgfzbfafwwqaazpgkiqcfwnsaigtzngavoaxvcerauucwjiiszlzxarzizuhobi".toCharArray(),
            "krkhooniojctfndqfcdecdxdlyytnbdxungidtqrcumkiqcnufuwitcvuaqhbtgvimflhyflsrxahzqcgmaohcmbecihwqegckslixzcowfwwvacjatq".toCharArray(),
            "fhujjcrhvvoxhglrfkutgzrewrjhuezzltkuydetbssiadcfnwawxscvllcfrbgcvtzvwdozxgizkmezigvhyackngrfhahetizpnnrmwzlgnrhvyfew".toCharArray(),
            "fgismcxvchcvrbmfrdrnefvrweoujstqadjofimjroejrtqiyjxdouwnbnjkhcdkioypwkzqafzsyrcxccctyagznpmxuphcdhrbusruysowlrvotzhr".toCharArray(),
            "cntrefoawvezfyczqutooinabkoukvnokifqnurlrvkwtpvmjrazbnzcypykmnyywdplzgxtdjrzynljgnjhdilbajnmwnluqagsidlnmemltzuzndiq".toCharArray(),
            "ottqcicbvpvnrbfzgsptxdgqdassgaiwudmylqbggxtxabzhtoasrilwidoqfyobbacorduzcqwdrvmmloffwsdgxsxcslgwoikflfgovctoafanthsp".toCharArray(),
            "zwvyqubkihgwrrdcyjsvnljnsldntveutatlwwwefeawvfavotqcgbrznwmgurcntvbrtzyydawbgxwwqpayquzfqmnkfqyanbtharhfsegyddwvsxtk".toCharArray(),
            "rtqhhdsotsqjtjsvbzavfjtimrdgoxsfsinzohnjzfsuokprmrmrahcozfwneptyzixnpmxqrrkicbzoumhxtjnsrkivbducltscipubgejkhjybvgaq".toCharArray(),
            "roliatgdwafjvxndohhxnqhuzixwqyphoaqovwrryycvwpbkyihlyrhazgypgnwupoikkbdkahgywhkwpujplsrkzqbffxavokhymnjourmtywppqzgd".toCharArray(),
            "rynsoqytqaqemaeynpohgaagzqvpretkcidqbdlrfevrezqrpeaxhbegtbxmfqwhbbzcglvlpqdvrvoibogirmomnmyvexchaelhrgsiyxdqsrauhgcz".toCharArray(),
            "stnihodnnhvnniweprmnopfjigdqohrjcetjsyxfhutvcrztimjzdoimwnenuvwxzrisphxwdsrgmrbwfkvkbfyzscmnxkmxburqcqnflgnxxptebppe".toCharArray(),
            "unensqcpdooekfxoykujqjgqazweqninbmctfekiuzogglvexrnqavidxehnspcveeqjkctgdjnkviquzgmbbugabpqtfsqlziwjkpsoyfavpqsqyeta".toCharArray(),
            "zacapsvwlnhkvdvhunvvuvsjokzmrtoqvrsklpjwcqixwggsvcpqzibpudclysbtlvfxkovmhglfmsxjwpbxxdnrirfilidxeiwozrdixqplkovgdwga".toCharArray(),
            "bvujozrzhuynfuegmhqlzfxktssxoyxsttbhuvjcrhrwcveqeubezyqtsisjhpbclemfzvjrcbpgywydqcjsczlvjdesufvhjhnlcwegztpyppbirmau".toCharArray(),
            "nnpwqvpmamulvjwzfaffwwfnmivduvzhiofajwplklzfuxebamiwinlwvhcrebapsgpdegrprqunnzpnlzlvnxukgwckzczrkrvrxogrecetbtjovumi".toCharArray(),
            "tguzewmdblxnesecgktmpxhqtqhonvygdsihrumuhjhmdmqlylxnkhgfxptkkttpobyfxkzguiuzukltvkggrolrdhbpcweqzcxwpyflhzkbkxwhifpb".toCharArray(),
            "tdsxmwoosthsxeqmfvxmvkphhmortetmjllvjajcvsusxmhcigqfqfmytcpmgkbryomhqyjlqfgpsptcvjhmrvmkxdxgoaxookvfkhsaoyqinjklvrxm".toCharArray(),
            "olwmovsevpskbqrlxjmnkewzngkiajwoutalospmkkylapxzajmknimcrwntgjhceknvcfhopfarwxsyggjvrvxitmbbwkeautvzyenplnihkcisjrpa".toCharArray(),
            "onkhznlxxpaukvtlaialylvknddywsamhmvjzgizxitieotgyvtwiqhwvmwrgzfolbzlhhmhqhpwvicvfvsoobmjnidthijvjkgtsuaibreybitgfnwt".toCharArray(),
            "oiddtgzcqkxavfvnzxxaodyrluxshuoyetbxbcarnztifoxeluhbzhsmbselosjunmsopugevzmaqjhdfqfexzqbtwmjrxeejytauzepassqdzuirboo".toCharArray(),
            "cgryddhuanymlrofstxtnplrofbfiqvnynlbssxvgwjtpxzkswfgnqxbyaigsftrugunzsihqrafobrjzwpmnoploztjfpazvuowowdepgmghdpjaevn".toCharArray(),
            "unaimvtrmttiqhgegklvsxdbaskayipsvpdhnwbzswjkfqqlabjuymvzhibhqranifwvdxxxvghbwymybxsamqbvyecovedgjzbpxamshuvfukevhyxv".toCharArray(),
            "qaqofteaxhgjhkygmmatgwbcghaphxlyybmfwrhwaofhafnotokcmlessehzeuzeymjufqqfgxpiecxyshaeugymngnrcnvabgvgynnflcprhmpzvrep".toCharArray(),
            "ycdlkrepgbpjhmphaemnhceqqwpopvdpahcmagbihrrqfiyhmmuvqbljzdxoyceyjgnlpotyfkrnupuhdpewssfrvehvglwsujdjxzjflasgrmpvdtrx".toCharArray(),
            "lyogcycilacfjgqghalsafysunpxjixugndklhuxhxeqfvymxkgzrhtlwklfsiaavfkjmfgtemljhjxgvdinkbahmnogvohtvtehymceynpixmossyfc".toCharArray(),
            "ailovawtqdomxsvxeyecltkigbbyzicbqqrosohitvwsnsstqwvbpimxjpxizcmqsdektnunirfvjzqbxlcntqmefmnfobxieduyqqnyhuvsultryygs".toCharArray(),
            "ovwuhlzxowhtbdtrtgrdcovwzpqznytbtsxcfybuwipxniohqhksvhrwwjwlhppdhofnnjjjtyhhgxoyfaschlzguxteokhyzonmxwxrueyceoalqunx".toCharArray(),
            "gofalzgclnakenyblwufaujgklraffaltfohgulskleqadrlzosbkbivmbvrgxfcfvllrwfbjkrjplwqbotlrdgffewnddpiycwqabtjnnueyqubgqmz".toCharArray(),
            "tveybdoegdphilxiossefoifffgnvvnosrptwdzdiqmqdlbsdvwjjgqolxegurxmkofjrgmbzyucjvuoqsxzzoqmnwvhpstzgaiziwahwukhrgwjbvja".toCharArray(),
            "lboaxjhmbcnjeyinulwthgczpaiqwtsjugktqtftwvdatnppymkgsnhhnpxllpvhyfboaijwdozweomcawktlrczjckuthbroehpntlqhknlbbqbzcwl".toCharArray(),
            "wzmfdybwgequlzjysxocjdpkgfmiikvgjhlohonnudkfetdxsuzezooiwcqgplmauzpbpcrlhbrnwwkrslvuclcaqsgffufbvwekavvhyoxxnhofvjzz".toCharArray(),
            "wbzmvhtcbzdwvkiwfffgucdhmrojcqiytjnrqgttfzrdjzbqeiwanbjzsykwqsvjbictowmwvdbeccuiktjzusynsklieguhqwahumfprgvviseulpuf".toCharArray(),
            "juuchgmloithftozitrzzmvjebfrqbxbytdfzsqqajxffnhngaoholstmxmebjgzdleeduuegtllguamuovjcpeqpqvqcdpfqvlwriazbnkiimwcdulf".toCharArray(),
            "jrvyisqkvfrocckummtqzgyhuwmxszceryczqvjocccfeobtawjzejjzhvwauzelzikrdvfgxjnezoxzkizpriqydmaznglmpxeutlcsxpwwfvysdxjw".toCharArray(),
            "hzvmnxlbewpvuvrphuhglgerbclhbudivawiyijcgzzcuqtdkblyhqpkucrwyxgtxfdxnnzvoyakrtqbwbzftqqoujmsiulgzpdoefkufmewhuaeyzlr".toCharArray(),
            "sbhmntfvosdpjjepoojtcqsjmspktbelclarhfpxzsmjbqyrgkniafumxjzqkdepqegxlxwmqjvtbwliiasifmwewvwgycvpgeotblgtwdpxbchjcath".toCharArray(),
            "mqnknjromodustowewpczeadghoijiryaeipqbdeqiykcogikylmclrlufvepncrtmhjqkngtosxczfpzqdbduoyzkerziisupekctsxhnummbbnseqv".toCharArray(),
            "afvbrzsqhbkesqqwklvtyrfmtiznopkqwgsnhkdrnqvigneqyamwrtkmcjzsbkjxsblznqsbgpjndpfdprcjlmvpyxhzjswbvhcjavmgkvvpmbtesvnd".toCharArray(),
            "jkshjcgsudvsmybovnvhkqxwrsampprycmiloogktbcibfwystgekfddzfrovjozvwmjnsviuasxfrwakcewjhciptwmcmlxlxiasgimgdlluhnelsdu".toCharArray(),
            "bfeqyacdppcaplahtkvzngmhqaoburyxycqydubukgwzrwikidlwlzfbzvdvmbtmdlnifoerwasnwazhfmdrmksngxjuyejepwmwmrojtgyqjyzomefy".toCharArray(),
            "oamuxxrwdaauwoqiherbnqtwqsmcwsbmspjpmanrcplygbipicqxslvkfhodzrqtgbludylfqwdwanlkpehjrctxjiclzugivrcysqdioieqypanvhxn".toCharArray(),
            "jsmvcoielomggqhyimgxxmnvbokzxjmjcyegookzcwikppixdquackxgyifxttgvrmcfaofdlnnaeyxhqukvejbetibnbkkuwozxdgcqvrszprjilvdr".toCharArray(),
            "ggxaqbptlznhoogtvijqabsrudzgaezgkzicaxvnxiwnxdgulpknsehmjgujnwszvacvyxkvggifjqzxflmzstlbcgnpcfozfqwfqgcymkdyaevhpjgh".toCharArray(),
            "dujfcwugdifibbqrjspxduvfyspncxxftimvegbjqirtljmucduhxpovidlmdktwsfsynvhdgazrklompitozhmjlxvqhombvgziegokgndqarcpbveb".toCharArray(),
            "dqkqpigyyuzudychgstmfwdiqfxtddwgvjymrgkpallflqorihgqgjyyqxrtdqbyzzlqfxhiltnylcstlylrhjrzhltkbwkawxsdvzniubgffybswmmf".toCharArray(),
            "wdhfoarrwdrubjaylngfqonxpoqlcctahafycypachxdsxddkjldzaaoqscsuxtexacbzrbdyaitxlwkwjnvjpmziouelniknkloeorepzxmkuygflep".toCharArray(),
            "dqqlekrrzabpmodscxxrwugjqerwsvnvnditqbkrdngqbmiejhxfcdoskgocddzrhjkzkxqokzgmlqsuypzcvqufyljdqkwzvjyhgrxsqdebwyxwoyyl".toCharArray(),
            "ouqohbsylqxgzynfrnyhqekodjmthmeyjwmqxgqixqqwqfehseqlicbnloiuaoslkhehnurmmjleppnjtdwdhytuobpqqhccogkecdspndvesjpnmmtw".toCharArray(),
            "moqaphqhrsmhayldbesqjnueymrlymjmabmsjebaznhzlvcnbwdkmaokmixmugyximptqqtpecrpxteaqknekboylmmiukfeyuxomqgqvziusmvkyiok".toCharArray(),
            "lfiztwhniosgirxwifndexxylujkezuqgfpzbynkmhswypsiuhnaenzqhkamlwesbvrdvgphnhdoxxytfmujzvbifdwqacibxaeugvbwdgmcekvlyrwx".toCharArray(),
            "myitbgkbjsfiulddhgbmpnovzlgyfcxrcflgoxjzpohmamphvsvkfjfewlcbpctuhgcxdlwucgicuzlprgzyrednrhpjjkftqhsvuprwvcypblhtrgri".toCharArray(),
            "nwwgglrrxwmnffkaudwrfvihipcaytklsityvlrsjefpjrpfxnwckgltwnvujfhbocbjnsezylohdfoaumeftqyrdtnmaupqyqcmlgnjrdtukhweubjn".toCharArray(),
            "tjewctlfnavntxbgdopvrirbqqimrrbmbfkfavknyiatfczjsogkzxnrnvdgpessldxlakaasctxgsizjolkoabdygknmehzjekmqmmkqgixasyjjlvx".toCharArray(),
            "nyanemcqtjpeqbqgpdrglbflvfxeqsdfrgtxuvqpfhuvlkdapugcxlovsnzihfqyljyheoxlvrgidkjvgrxgflbxycgihwguhgcnuzzsqfavrlqadoii".toCharArray(),
            "zlfannkxlsrsztgvufpmmqigdyigmsoodwqsjapxshrtcxpxeeltwtbasligdzwgvoygqodjxvebutabamwwfxyzihilggtdvtjljpwgkbkgwkhwwdte".toCharArray(),
            "crfkanxguslrmvcvkbewcocyymvxpqdujiekwesswejibngnokjsanrazozrgclplrbjvwbucmcdzkqowbgwozxopwfvzsnmjqvfmwzqkdtjolzkmgjd".toCharArray(),
            "hirxgyufqhtbyoimmhdwnygdmfpanydviwupuowmyqoyewmtgppvqxycfpcuqgryclnzcknccbagambietduqdyxucskijlnxaobkbdmffvhryrxrwti".toCharArray(),
            "bthvwziglttitjjgnoustrbmqskhofrpzzmvaublpxvliervunpnfqaxkmgararszenbarnqqibypuwjhlxoezlqlureuixvokwpdlftuiulcqwlbvah".toCharArray(),
            "unyhhrmdzjyqvvfzimucuopyemjijlrezpligzmiikyehffsrzunomnuawejkwnjlbtuafcjscpbhutytqnjcagcykliibtwenqeuupmwgqfajfwbshf".toCharArray(),
            "unhsavdiywgclwigsauqgkvjwahxsqdmgmhgjkqjixluvwaoyweehcpfcyevphjvwqdhatrjsefqaheydkfmmwrpvwmkfxfboijqdcbwggmhpshtemft".toCharArray(),
            "jzkevyqcvxglfrektfizowidqqyveeopdavaylctiihpzlassiugfcmvsksxqiovikxivaegklvmwvgogaxndlkxxdwonllwvjeqjiwvvuhrroixohkt".toCharArray(),
            "svrraphnatlvcsoncmkygsryizxyiiscfluhabwbwiyyaoncbyajsujavhyersiydcfggbjcjhdlwqqzqsiimskizjosdwqjzvphyyjkhovfhlexepiq".toCharArray(),
            "jsaidoahlsqmnhtlfevovtuceabkpjdycfifukohcetrlofsucjrvftcfvmxerxixiqtueazlvqylvthaczvjsxqpmpwfngcxwxrdxsqulofijninmew".toCharArray(),
            "gdnwpcuvrazozxicwcsrniwwslefxicgmredtyalycbzblbxovqbenxwacdymfgawkesigdiigijslhihzjnmjlpnonzwvcufgmporzxyhgsvpaeplrd".toCharArray(),
            "uesjshlqcnljvxyjrygrhplegnixybdvfveafrqjebtzbtlurtlbiwfrjoojrrexplxucpfjryiustolpzoxxuoikfrdwyanlzhppnyinjchesvttjrq".toCharArray(),
            "fhyrorvnpxaaziqoxqymzcweurxncqfkadbouybmwcovmellxjzwlvchmaurszbuecjadmmbqdyejjrgurdhmfobhkscjvwpzhrcugdmjbrsmizgbenq".toCharArray(),
            "ldrvnlxwgvnhdfkzlpluteofpnoqrdgdhzaumxtuugcxnoyadkwyqlefyuysxgxegxbuwupqcrqqfoqkapjrapyajwuidrplqqfmkwfmpvewlxhmmsdm".toCharArray(),
            "hbosyjadcpqtfxhruoejjkgvhphthmhqnyinhisjaiehgmzcaflmptjxissrechtapjjabscmzjslkwnphbhdkgneyfkcoeeenngqikchtwseshvcjcf".toCharArray(),
            "viuajzkloqqufdcwlmauhxonrwjvhncewxefyrsojikpomnbanwkmkxgiibrwewubabbttqdeauunhvpwtzjgzpqhsifwezzgabcwrfatzuiiryenznt".toCharArray(),
            "yejiztnvzpxgraintppmqlvyfvesusnvywdxssvrhuzbujqpygbqtyqytvqqpflpconwiknqgnrawjpxpsplrgjmdccshnhldwhmixeomxqkghjyazjt".toCharArray(),
            "hsfkwkcgxlrdibpqavhmsxyyfiwfjhaqafayreeppyuxzlqbgxpyunybxxigeiwgqyfhclyujsrkdjllialdomgljpupxswnrdxvqvpaqjkvswhbwugm".toCharArray(),
            "goapduhbmfqfipdansadblawjjzhehukvwczqjceoumykpyxhbclocjxmigqpcckyglqpnvfkjfuygthhvuxxdullabcdgpdmcuesrlcarwyzphimcfj".toCharArray(),
            "hbvvdyxieomtrgxjxknzdjzcagkokrxssunwtmezdquuytfvesuhdtmfcytmqsgkptgkillldghczozfiwpnrbutbpirhocwkkiuxufbaofbcehkcyzu".toCharArray(),
            "ztpcizurqyqaiywgsdjsrowvuffzdgtezkgjkcaacqclrytjbeesuapohunkciqbtymfbmfdfjqwhlhkrlelntaupperawuvvgayuhdzquxzhflzqpkg".toCharArray(),
            "kmazehsedmbaubyqkcscypbhwogpdtvnhvolcgriusiqvhgflyhjokqkyzbduwsbsgpwogeibpawyhejfnsvakialjefgyhahwwvedgfsgespkbvzvqz".toCharArray(),
            "faatkgysgfsndqlkvtrpbxhrhiohdeilhkersejzmdoptbzrutgwqopyydhejrpqevhwzsxlvodrpeimxqiqexqdczhlqycuvjtwesizgnsytaktrujx".toCharArray(),
            "tzcvylgolilgugdyynxhcqfvsrollxjewnzwzhnkqytmgykeljlpbskwjbhuasazgbvhjitbimnomztzigokzzgkcpfcihbqjxzsfsvqhketjztrgjdh".toCharArray(),
            "ilrmbyplgqbppajvuendqrxzrsszbwimhzykypvggyvvagsvmfyczxbsrtrvrbhbahlaxhgfhdaijvfvcfxdfavwuornpaoskashjboqeoaolflqnjts".toCharArray(),
            "jpqfdktvmhnwjffsitlnkldvtolgzfalwqsbcnwpvjlgrrzzkkowxtsqifyjmauitpkvcgmzsyglrfmdrbaqwujgzhqoimwdbiyerldlllwcsihjljci".toCharArray(),
            "dlofugtctrfwagattgeeraikkpvwbxgekwlfdgjwyrsaxvtqdxwuzegjvehwbndokotnvclvtfvsaokfngamkivimdeqsjecaxrvbesxmnpodauqguct".toCharArray(),
            "cxbrchhvrlzrkrolxgkjvayycsokosfspijuqqpjdocnhsbfalqvnovrglcudhpsqymipdtssxizpjgrwxmknjbuufqxpfrhegrvjkpbhxdyilpfkdry".toCharArray(),
            "muugakdpsuyyapvkzkniisiqgxxqaoomjiulvxcptanwrkisuvaeqixyhuqhlfvwpphmoldjnsfecnwxlyddgabnxrwiyteqineyyihnanrdcncnlhqt".toCharArray(),
            "iriflgpjzvbjighioqvqfovibzvohohphrwsxnewiffsnocbezumnpuqrreyhnppenjbanxivecisemyfgksxgioaomjbdyfqkgqxfaujcdbgrzlzmfw".toCharArray(),
            "upludzeedejtormowmkfppgxgilfwqeqgrnlstqvzbrotferroxggfgmprunjyepptbhotfnwydrdjjwaidgpluhcouloadftgpjzwxxuapzkyvmgasx".toCharArray(),
            "lmepdzdrzgxvoogpkdmggbfszcehfwfqklinklfmtejhspwevikbmrtlvzvavctfnbtaoaohgxoyomejwomihhwcgtddvylkzgkngywmxmmoyqzwgohp".toCharArray(),
            "vfreawhvushvyukguguusiisajrgxyxtfpxflgcizjdzfogawcurlejlnculcrghifowlqemcjmhzujwwdnhjyvxdpkfisprxdniwtvycjhedrabwplg".toCharArray(),
            "pgdsxpyfhnyesnooglmlwwpznrdlgorvuwqrloyudzyvopkxcyizuzajqdvyrovnllgybhtegtauimrnkbmfcoqusnslcqznbfldmehuyjrivkvgmjno".toCharArray(),
            "yfjstddvtcixkvawajtatkiqugyipnzptkhmnljjptgzogyqrrqmdbdxjbiyphqkrxyeihnaavbodzhvszhvcmvlodmfmcrdzpjkwzmyunoynvthvcfx".toCharArray(),
            "pclffzmrbdwcsfoqeaozoczdyukvwpulrfsyeerhhpmbvarbdfcrkbuivgfuyzhrhasnglxqbjrwjlzmscfcfbmbkrxirebaetnnfkdgvuefhdtahbcn".toCharArray(),
            "cpominwbrybytrlybogzkmesqzszcwmfnctwpszhqbfjsqkvgsuqfaixccwebjlolfmdxmkpprahjmepfbfkbqhfsfktovkccwfbkrszitirfnikonwr".toCharArray(),
            "dfxwljrbgbfjymmkdfknasghfouveqphwofhzzkfaqqacdlikvvmpetxsnuygjiczplyovernwrqbeylbvxrztouiisouaqtsdsgbyxourewvejxajqz".toCharArray(),
            "cetkooziqrcixwpyuooohvmdzwczfsbjywvmkwxbozlnxclrtzhawwfwshxzbykzvfohclismwhjyscrtjsqfxozhlakkkkhsaownzozvxkvpmnkxhcf".toCharArray(),
            "gsenehyorkxlmlhzkxafukblwqytxayftftzmtpffmtrxaqiyqpucsgyiethgunbzicndruidnzdorlojcilxqlfwepfyegzmlmpchzguyjkrwaaalnx".toCharArray(),
            "byfacwfdancoypfbyejueuhvqhxsskqwivwmrbptouhpjoqjsbdyvktnuqfmcvikseylhqgyknnvdfexgjvdwqqqivcktnwltxzbnfzxvmsytyybjtef".toCharArray(),
            "muvupahkpdyiaxjpekmzwgargysqtwxfqvcixjsmosurpgguqvvpdxgmvbcrxzwqwaatjufancrekzaawwratamrbqiyrgqojqhslpuatlednffjdxjy".toCharArray(),
            "xxpynzyhipvrheluvguqtztigzsjydjvbbvqavzkkudubpoyxjpskibqjvbjykgblbuoxtajqedtvurudgmnrpfckimlssmgwguvcugsamnvgepjneyg".toCharArray(),
            "tfignwrhrdnpmjmqgsigevekbttoztwtafbndsvwxkljuxbcsjiwgmhkicahyxcyedmhvjgvvterrgtlrehaqokatmirjmpnqdxnodikwpdpxxaqbiqt".toCharArray(),
            "ycutpekaqcoihlwyqgimvneukelnodhpidizjvzbznkiaigqoodmejgonreexnvfqfebadcbtmktuqklhpxlyfbnxftwsobkwhlwkqafcmzzclmlcjwc".toCharArray(),
            "oyrnfnjybmkxtywgoylqkmrozdadowffwzuemgcpsopmmnualftvumlvqlzgkglgfgkrmojgfyurlouwwntszenrsmyctliytvshlboqzkkmzekvtfpu".toCharArray(),
            "jcmbpmdkzokvlecyfspgdbuehebajqwvskyjyctysgtfkxdssuyvvtbezcgjsdemncwmgrmaxhfkgjcyfcvbvwfxamgsrmhgofsxwgxwpfgwokutmswk".toCharArray(),
            "oehpsnjjbqppvkousmsiraehkacwsbijhpazelkfebxbnlvgznqspwzzyeytfgcmyenerzkvajxquuywkoozkqziuzdbhhpflckfbwadfxtburzehodt".toCharArray(),
            "eeeadhblpqscuehxcicjhynbpmfzalsepwetghgvxaxtfhshpvryteckqjjtuezkcefinlfnlfgsmzcbwvbpbdbtnnmhtmtvsygfllszqbrcctfyqhpr".toCharArray(),
            "mslzfxjalcwddelopfnighmkcsitbzkpuxpbxacicyofczwtgjdnqqxtkimnjycdwtfttjdyhrflsbgzlkodcnwovkbhldmhzrcsafqjxywrzfqmreqt".toCharArray(),
            "sohpzkwmpltocvjfcbqbzptzullnqdgkspbtbafqlahpxqwzrnbtcwuyhflzltjdknylnddydkpccmbuzepdajdkqojbjvgtiegxjjvowmqyysuxyjcz".toCharArray(),
            "sfjjvumgptzxxhwhtrvpempegkcevgfomqzjllqcgrcebynuskjywacekglgnqwbjxkwkcyrwcxxbkrvucttcxxpeixtbvumsgielixhnueqgvlbzgwb".toCharArray(),
            "dtsjepchkwtefdlqnizaddqjadmzjicnevykmbrxzmderowezvheaxnadcbmkebqbaanbtmcfshwifdhdkldjbgmdhzplcioeichcqkjitgryjabvohe".toCharArray(),
            "pnruusliutwbcaigtspblxumixpdlwicjbygtjopfmqjpzpitglhegtofisqfcuqdswydmpizitqjkycrjjxrclwnfosjikochoiveswmmmvwkxpwjmn".toCharArray(),
            "namahaurlfhnowxjaqgmcsjyfiobrcofeahmdcfojmdxibikroyvjhvoqlrjofqsiygnalbjagikjqvcftxqbtetexcuctpmtxztjcellmvueqzjmwbp".toCharArray(),
            "rhiyemujhjvahxtsbzfmnajstidfgfuameyrqucyexynwuhyvmmjoxbhhgoqlkqaqqthkvhquhfrdmrzadkrdnaktpafbsfsiabtvklprrgxfzyidizi".toCharArray(),
            "vzsoqvvsncmwcprxzepsvxpdxplcxkkujclczgwnlklpzenaiesebkjyzuazektppetonpdyzonyscabgthkfqigmlfqxzhmfbdssgssvgspktstobdt".toCharArray(),
            "tnbfahxygfmlipgayyuvgpkrkdmyertygufhbdhjivxslfuldrgmgqfqvrqcklcqfhzjkguuctopyjceciqiavawmsawdcoklovwwssylhpksroubeec".toCharArray(),
            "zganyaldcznpnllkdgkopcajvqfxujzvrzkpbvsfxhuksiwvojmdlmogdtfzcexvfhkifencnioiqndgwrlhezpjsviwbfrjpdrwjfywnoefbklxdwgh".toCharArray(),
            "vwsnrbjuicdzfvvoavmpktulfflibrswpklinudywgzdbvtdqfscamofrbqsuiqkubskxxivehahetlvzdzzqphjqxclhuxbyrlvpvtvftcjnpgotgpl".toCharArray(),
            "vwuovybctyerrroinhdsbidqxkesstdnsybnyesrcwkwpzeciiwlsabrmhkednrvnvkmzcfeasaqtgubotpitsahakldzeapbmddpkjrcjhvrezixoqs".toCharArray(),
            "iqzickneqptscyxriginpskgwjovzhnizmscyigoxbizzfsjlbwcvjltsbouibeipymngsdevodwvwhhzglwpwpjafdigjsxiemqyruvfarbyzkzhvvw".toCharArray(),
            "umfurlezuzwefivgzpbhrvipwuodrlzlxghqropmpnquvlaxdeeubomzkacbmdpljwcbmtpbhhwevybyehufxgehjijxnyixwmajgpmpykttjxtpeove".toCharArray(),
            "wblfmwezwnwvbyejpsyodshmpbbvryzncnvolznkomfqmlzcdasguzujcygtwijaxeqidgssszkgkliolauhcpqgnzalhloepeoukjoeialtmvjzwdha".toCharArray(),
            "uzgjaixhtlnkpehcnvgxwtskpblnfunbuvlueiezvtmmxtomoxmmqeyfgksnehqadbxjlbigwutupjiegusxbtchdxwjemmhqjqbmbkixfenoptvlnsm".toCharArray(),
            "gwvltrvyejhwsaxgdjqaovpdmkaxyskeqhqkznkfwtbqvawykmbyjsdvddvbxhhqoxcpmmuihxydyubijeisxoqatldrskjiilywxufgsfjqanalrkfq".toCharArray(),
            "yvquitncewlohjkgfrmxxwpzlpkecpvcnnwvhjynfjdmupubjhzgfohqgtwikrkxfjvostdaeioazjbiscqxrxpzslhdftcmexczsfzwppyoacxsenrv".toCharArray(),
            "niuhudkbzpndopchwdfltezvgyokohibqeikivnhmamarphnsnantzjbyxnmexpuczgmwvvivhjowsdrhdeadnddkrrroinsjwegrzqphbffujwbmber".toCharArray(),
            "ohubylupvjhfhmlbndswfxczgyavbemsohtoupdqanxibkjonblsaprhpucraqjoxefuvimvxjdytmpgpcbqruzgodzrtihtomnjxzfukivdxklommed".toCharArray(),
            "hdlxilocvyvkkkthjyevjzaijlwxabajgngpyxtuxoghyzrjavglugtdrratuccdrlusknmhduodthovcuiwadbtvdnphpszcmtmbfvebmhwtxswrcur".toCharArray(),
            "gynbbaslrlmwzfibmgfnspjlmdjggezmcmpfohsgsgcslmvzscokryygdhojnnxrcmzqurwoaainpdnhgbuzbuhfbvqrloipcjfwdendgvqvzddhhzgi".toCharArray(),
            "tqpuninyyynahvzkzmnfhebijgpqfybyosubaicyirbpmaanmntvtwedevtjtwjjpflppnqxernttngfcbcwxizbeumztvjibwzqlporidkbqrissnqs".toCharArray(),
            "vpvbmidffmpikobvgrmquzsmqagkpxeloaoakrhrfwapldmtuzjqybcqeictfhgujvwtmemuamjnryglzqbxtfpzotvvabrlyogluthwhskzqskpkooe".toCharArray(),
            "tfdhzafbcwnamtngmufupptfhfxutlynrdwsebtiagioawxmscihrbpajmuczurqaqketemtkwimuhbnjjwcnnewzzazvsrvkcbdipzsmjhiqivzrubg".toCharArray(),
            "hhejgfiezbbjfdonupigyppqxmpqiszsadbiilohmqssvjhpypyxepnbdfumztebwhmhsaogsjansifqxdpcsffvmzjlupprwbyqdoxyzzlthqkhvbjp".toCharArray(),
            "gqlsswgmmvfkyfbbwazvznpjfbqdcbsltfdlclaogfaelbijbjedyvogwejbhbmajroldobltbsgfarglwlktzqsfbtochplafyftbrodjxiloqymcig".toCharArray(),
            "dayjdtxgcotctuiovbdakakxodvbhgjkghvmatsejngfjqthrwhdyuapxwsecbokkmwmfqqqgwvrnrygngkoakdzivdmytzifxumqkdwianxroehuovw".toCharArray(),
            "aavlxaxvtwfzwznmlqittxrklxthlqfnqcypcymyurxsskefdozwmsizpehcuoplrqctoprkgqdbdhgiwhgkzojqsssphkayactqtnacdddinjqlrwvs".toCharArray(),
            "ngjhzdwinyipdbfwqiywldeanxlgtiaiplsopoyengusjboajpwxsczhzlpvtqdibxysmwxbettowjqiyofrqeasrqnngsvjqweeubfzwapujhckvhdn".toCharArray(),
            "odfftusbnqnforjiuqjssambhpleyqsmuzupuotjgiquzbfvronjrzmyoafpqxbmwxcsovbwdtreuyznooyfnlgenltdiwqgwuzmrciwwzaszbgopete".toCharArray(),
            "pzkckfiueabaucolgwheyjxxmdldhhhziudtzlpdnsfhutsdsbhqkepwjbztkjssdxneldkyvrgsnavfccxojmnuponzzhsefhjskvqgmyyzzvgdzdri".toCharArray(),
            "qgffvshucbzhikbtfrbrqztrwzuvfngvwlcrfjnhmoqvarqflrzbsuuovojadpvzcasilipyyitzzlgkehnwbhmxxxzdpverxzzihrghzbiampnqyaoa".toCharArray(),
            "kczhaampvrgssidbzjiylrazinsgoiialhjliwcfpiahqdirosrbjsdrfvyvfgvqqfdadfhsqjbiojaddtgnljgtegqkpmcftghylqqdarmocmtffaut".toCharArray(),
            "jboqjecysefnmmlafbdfupvydrgltaecdsunyylrfrerfqrktvrompoqgudzxjdadapbybsduzvbromklfaywpqcjvdgejjhlyijbdpxekzvanfmsgmp".toCharArray()
        };
    }
    
    private static char[][] getLargeBoard2() {
        return new char[][] {
                "drgimmrzmyioqlbpeezsegxlohvwheslvatjmkkylsobgqskwtebbemqljosngdjgz".toCharArray(),
                "sulfuwxiafassxowypamhnyvgldlwlkrfwwzuvkwbkpvhfrhuuwcjuzpfddeopvunr".toCharArray(),
                "vkmfgpsxkzccjzyfbhzazgfekuthqhyltltzalxnmzpvypabybexkjbwfxevgchzpc".toCharArray(),
                "ysnxfbxwxxnzbldhlnqojynnttscsjetdtqkvpiupvtqjwxwlpkvnykhteloqqhtlz".toCharArray(),
                "ggpocgmwwvuvrgmddadnjxuulkmufyvlgmcjsohqjdlcjafoajeliyhtkwppukdcxf".toCharArray(),
                "lptugeytghtnyvwciecqzmmodibgkylyngsvkqrqakgygccojegkqubteccranppuj".toCharArray(),
                "ngaexcofcwhensivfaqgvwiznknezjompqqouhtwddcqxmocogkjcslscawcjmqaej".toCharArray(),
                "raqmwvraormcvaigmkyxcdxbhipxkwgbwyqvujviakkwkscwecvjfsmmcbknzsoytg".toCharArray(),
                "vnqsxqchopbqnfvjoadangeztftjdmqabityavhpkihyocjefmhssntnsoxydpyezr".toCharArray(),
                "fzpmobvyblckrhzybtnujilggoxgswaxvpkmshmwsoijwhkzdxwmfhunvrunpunmlz".toCharArray(),
                "afgmbadkjbtvawvwicdeqaxmqmidbvcbakqckvovwhryemvooatgbqsrfcwgxajymb".toCharArray(),
                "cwwqtuxktdyqspsnxtdqmksksskeqyfsuekoyharlbhfqasnvxfkkawcsjgkhoeeso".toCharArray(),
                "ssxukkvtpnvjdtjkftkbxemgquuuyoisggmsskoixltcgcnlvzptebzuvvrvjbnrjc".toCharArray(),
                "mcmaklldouidfdcwyiyxfvuwrfxgxhijjulviyawsizamdwmmukrsgpjmmpjvaueuh".toCharArray(),
                "behccambcahyntvzmnfbyrnpclpyrmftqnxtpjwtkdrxyowkbblbtbrxogwfsdylsv".toCharArray(),
                "ejfccriuogiktmngnihggxnedhhbuazajgdmxlilrsxkgktwtacbyrfdzmevofwylz".toCharArray(),
                "mimwtdoqqxdjtylvzlngqouvjjcfjoexwqtswjkognzzlmvmakuqypnhyqnjetgcmz".toCharArray(),
                "ukkfarszqgnnupxpgvevfelunrpvubwqngvnxqoqyedstdjbanxftkbierdyuzqiim".toCharArray(),
                "xfemxeqbwlgingxkorwpzaifafgrpofmwjatnqwlcctrlrbzkzqlabsagzrvpwhnhk".toCharArray(),
                "jwahkemfxxyyyiyqwatoazpuwhqgwaqfyspizbqwaoxazxqxxmlxndtkmksimiqmcf".toCharArray(),
                "xbgnyidxicuabtmnsasmmeyemkocwqjtupiuzmrhqnksgyhyyzkmfisrsgwrzfmtxx".toCharArray(),
                "nyjegzrstxqavrbidgqwaleyedfqwepjdyplaidthtwfmxnsgdoiquguynnuscgvbx".toCharArray(),
                "gdglypguutuhlcnbkdvsytflqxnysqxatfluvsoplkzymmzwrwqpswcitsioifoela".toCharArray(),
                "yguoxfzwdnkemcactsywcsomgyswefyensvkxwjcjtivxlyrdypisfuafoxktvqiol".toCharArray(),
                "tnhestzcoxnoqrnfbhkvirkfbfcuoqfjgpnaiocylqndjcikluhtmrapzdjnvrybin".toCharArray(),
                "dqbgqpwdshhdrtxaolupdtsoinfgrpvwfwcylabghljaggbuuvlxqdlyttgmibiqxn".toCharArray(),
                "olnrrveaxkiyhevsblypjtirfsspiscyfqqynuakhilqpgkqsihdbpviipyshcrosh".toCharArray(),
                "mhdmumxfcmlnefvmjzbehlvhedkxteegmjsgwrlydyliejunkxtrlozrtlonpuvbdp".toCharArray(),
                "jzhuakvnuzyqoiqhabxbsrmigdcbffqohxlhkiughtxvbnedqbgkuuscyudfzwvgvi".toCharArray(),
                "pfqkmzflwiaaoqeuayrubrogwpctyacnhuzvuegqngrbyxxavouyfihdylxylbltvl".toCharArray(),
                "oprxggfzjeyhevxzufjdijohhcivxggnvzkdgsepwcycywdudnxlynvgrfboljchio".toCharArray(),
                "mogtgevehvckpfzotycoevthkhqmoaccrjvxprdwoijeniuigyymuuveblsroutffp".toCharArray(),
                "cvihtwpccflxntvoipidtjrnafktkrkomuxirpkvuxsjtoxbffgbqxoseyoqqyeete".toCharArray(),
                "mmtzhnwcypqwsvdzyuynmdnatfbakweykzxrmwtklligjmhhifuwkkzgpagzymailx".toCharArray(),
                "bztvlhiupriwbqbxomhnsxpaynoyxbyzarwlaehpyplzhpwwbelvdbxbqlcomanmtj".toCharArray(),
                "zwnhllwzmgojcrpnosqlvhwxxkzkytvxrkgcyfdkltvpkkcyevjaehzbrbnpwipnsv".toCharArray(),
                "rsavdnoycblhzpclriutjmwwdsgshaqytsvygmyinjrobtbudwpmklkndsiktylosg".toCharArray(),
                "myukjjwaaxwbtzxjohuaxatfmmfzazimycyjmulmtjpnlnyzwuzvwscjghighsuhvv".toCharArray(),
                "sjpdvlpkaazybysatpvwadfkmodixydphvvegkqgksglqanlpkhropcadfibfmsojn".toCharArray(),
                "urxkzjcfwufkgxunokeqkkxvnejfssvmjuziebpawwmethtityaeiabvekazcvnnqm".toCharArray(),
                "xwqmyoilseulonlqrtquoxeryiolvgauesiditocxiplvbbpuujltoeryueubeqhyz".toCharArray(),
                "kguyirgyeebhtvbeiuuontjspmwftxgedaeorloxrpfmmiqvfljseuktgjacghgjjm".toCharArray(),
                "zdxnaqchcpqtmvgxpksafajhcrokcaxcdwrdpulrldkzaqwpcqrjrcrvthiyhfakdr".toCharArray(),
                "qsndmagwbipyztqrdhvufrbnpjurvzkluaogcwceeteenuxseumjnpycasvwtihniw".toCharArray(),
                "tkuyqzrufgreavamgoegseaoatwkhgiascajbufiawodtprbdvhxahlcdjmkrumkxn".toCharArray(),
                "vahaljzzmuoewtbfrbpeesqsehnqrmfmmopxyozmipsgluocvfibzyudgjvzvbojpd".toCharArray(),
                "hpriebxwkiqamofvrevnjdwedthrdzwkqpsuqrrcajcmxjjppfeyibfnuogxpcjgrd".toCharArray(),
                "akxtoxdrlacvrsawqkzxyvmevbjgjcmkmjfdgiurlwoeqoajbbgzxufuyqahtmthvz".toCharArray(),
                "kdhgxuflzvcbgddnecjlyheyrznkgiltovblpgyoeaskfxzlzlxxsbxlakyivjdjef".toCharArray(),
                "wunuktxcgczhoasnznqzysjwagggpmlngaitufxajzjzbcmdpccpulmxuufjgqzpsh".toCharArray(),
                "kmohozgyzkclntqpimcwlwqqizihobqapghefqegaisnbkcjyegkbyalzlsnmkpbqx".toCharArray(),
                "hxnnenvycwieigkqsnovyogsductxssfqfuuuquyocewkomfedaetgxycztzulgmsb".toCharArray(),
                "iorcmhgqgshuxlxxrsforhqmhmypysqihjmvrsoxkxrikrfblnqeuirdurvujlesvq".toCharArray(),
                "qoignudgcnxkqlxgptqgzmzuilfmdccvsmbfhemjtlvkwssmojunxujgfqsktxgljj".toCharArray(),
                "tqqfajqvtnqobezvtwreeyuxlpwtdfcwwsbyetvzinnjtmhmlaspznokckdfqhboae".toCharArray(),
                "meyjdgxtsqfzfszxiamwkpjpwzxypzcddcmillbdejelbfklgxksotikufijenmjry".toCharArray(),
                "tcmxfqglbjrlxxkhpyaxjuetfkirvarpedmktuvwfokclulbvlaghhzmtkfpmxeqas".toCharArray(),
                "awmystmcwazhduvfcembtgnyvzvbqwtsuhsmahrwhsgkodpqhetamhzhgwkyudroml".toCharArray(),
                "dmsulzotlcwdsdjnevufedbodwtumfgptaleczxpbtsvzdjfyfkcknsolliyqqpkrb".toCharArray(),
                "qvcqkgjfbkimpjuznepgsatdakvqwotojveubqzfahrqsnrgsgmkjfpjrlzpbsglqk".toCharArray(),
                "hrcgwdpqvidoqxxeigjzpdmruolabbnitpqrufjrpnihkflulxuaaitwwfxxgmfbdx".toCharArray(),
                "tadcrurzccepyrmusmdllzskzzwgazetzjytfpujtzzsslmmapalrsvsrryusenunn".toCharArray(),
                "ntdhewidobpdnrsnclgxdzqetkijeywrtbbxylboosrcjmrnzzkfbcjumtfrrckmfn".toCharArray(),
                "kdznspflrqxldxmpcnrnkfipwatjozyyezlypskiijtliiamxrzhxizvkugyvfzagk".toCharArray(),
                "avfkenwzzehztftsoscppokyphfqjlckhhwlvukwzuvszqmpkrfahrayyfoiqruzys".toCharArray(),
                "kvnxrorpgshuhsnmuvfuvebkordkrdcdzpasfthnlpithxhdunxqtycjrftkixojpq".toCharArray(),
                "cukjivasqjpymknlailcrdjmnrjddyufvgqdbrvsamspwhaypmcgpnsehdkkegrzmh".toCharArray(),
                "epabjdnbsmiumzgrfxezeldoxhwogiykzyljdamvmxqzwyscwwbaieqfnmwvwuhvss".toCharArray(),
                "eyvrvholikmaoizskjwaqmomhkgphbjozefwoviyhwbweaoqlmsbagoiswzzzipapu".toCharArray(),
                "xdrhdzdgxjinztbtvcblmtjlujtklkgipyrtzuzyfingdozysaletvpqglcrvicnit".toCharArray(),
                "gjqhjvrwcvlbvdehkzebpmmrfkchxmdfwtmfqecubpwwucdebjgrvukbgokfbpkxkz".toCharArray(),
                "ebfivgxtcsviyxrgqpbaqjpcpqszpcytdfeblbuqvsywprcfgfhypybeotdfvebbjf".toCharArray(),
                "cxiyneqlaheemlkwjzukdlfisbmteyygvjeknxxpebttmdpyclkhwqqptekxcldzuj".toCharArray(),
                "jhigynkrgyxxwbihjhzzwsfipktujnfvwodudnojmlikmqrxzswxkegbozxzpfulta".toCharArray(),
                "iynwjbjrmxjfvjytgkxmmlolldqholhwjvuswdlibvqweopmypzmanalqqtgeadpxz".toCharArray(),
                "kwdvggqwewkvjlkkxlxzypqtvwwalvavrdryljupghmrsxbrkaripjekfalsvnopqh".toCharArray(),
                "ndqjuysgpmdsgnszyhicupehhzuxqmedpvpjthpluvdckwbifjmzaqgjsahimlodid".toCharArray(),
                "oemgpibuknslwywkxybgivgpfvctylynrntivwcijvthtsssqvyaqhrxcwrchrraem".toCharArray(),
                "icikkuhfbczvvsqvsicmgeizjrqarxnzzxjjrtqvvqqqijmcrqoxvwygnpiemvdnvp".toCharArray(),
                "yoiojdgawojktcahcxgadtpmadjdqeuotefeklggcrqvuqewokwteohetrjkxgaskf".toCharArray(),
                "xurdctxsqrlupbfnwlberxvahugjntpmnirsbomtfxnuaukzhndykaztuhdhastqal".toCharArray(),
                "idzuyhunduinvpbyolyphvwkczeypglxlmrjtnwzkgofypeodefmzbwecacripqtbk".toCharArray(),
                "exxcwhlknjctzhxetxhrdktfdbuuwxeaubesjpfyyjrzsodnnneqzzxcctwyraanee".toCharArray(),
                "gpwnnwwewosbbiohapgysitoimriaxoimkvzhtdfjxgmhxtimbiejbvtoodqltyzev".toCharArray(),
                "ynqduzcclkzguohcusdrltfojsjjtnercwwyvzbilaofqxhlpmccgksrecbyrhpweo".toCharArray(),
                "ubnvkayyfoyoznacqioiasmbqeiiaowuqjsalqaqeyggoikeryotqdwhhgphvldlwv".toCharArray(),
                "nhnnzsohycpiiiiybybxhkewtbjxmhuzqiorceycgomqyupasszcdfywgkvurqvkam".toCharArray(),
                "bcqaexqqpomeqgzsiczjaitwcmoawomascawbsoricxziwtrasabavxfhnfgbrgtvi".toCharArray(),
                "rxahqkjnltmekmzmnbhmgpznxcgdvcnobpxrzielcqrodqbsuihcxiqulyziamzbdw".toCharArray(),
                "sdfzqhphvuawpuhwweeobrncaprztuvlzcmplcxhyxfntmjrtqgwhvyjkridmgrlkd".toCharArray(),
                "dwhafgzmvuzfluxtseosqbkygygzlrfonmquupgqjhxvbuovafoqiyroyzqjsvyhho".toCharArray(),
                "begiurptotnfopkeiscbicaymtvmafccjkmfcdyqwnvnchrmzwnkyqkmlgalldpund".toCharArray(),
                "zrhxidmfqonidogqaeilrtrrfewwamazdjynmmvfaipdyvwzbeksydmfhidhwficoi".toCharArray(),
                "pdukkwuzctwasxgesehglqqrznwjpntgqntclpdpizpcywgscnaqfrhegfnxsgfkvy".toCharArray(),
                "mjopyyqqbrohlsxmicfrhlxukrdpcyqqheiieayfropfgmrpowixjfuvxxkbxathgb".toCharArray()
        };
    }
}
