package string;

public class FindAnagram {

}

/*
 abcdef


last 2 ef-	f with by all cases of e(e)-> abcdfe

last 3 def-	e with all cases of df(df,fd) and f with all cases of de(de,ed)->
abcedf,abcefd 	
abcfde,abcfed

last 4 cdef-	d with all cases of cfe(cef,cfe,fec,fce,ecf,efc), e with cdf(cdf,cfd,dcf,dfc,fcd,fdc) and f with cde
->abdcef,abdcfe,abdfec,abdfce,abdecf,abdefc
abecdf,abecfd,abedcf,abedfc,abefcd,abefdc


 * */
